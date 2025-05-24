package com.viasoft.projeto.envioEmail.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viasoft.projeto.envioEmail.controllers.exceptions.FildMessage;
import com.viasoft.projeto.envioEmail.dtos.EmailDTO;
import com.viasoft.projeto.envioEmail.dtos.EmailOciDTO;
import com.viasoft.projeto.envioEmail.interfaces.EmailStrategy;
import com.viasoft.projeto.envioEmail.services.exceptions.ObjectValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmailOciService implements EmailStrategy {

    private static final Logger logger = LoggerFactory.getLogger(EmailOciService.class);

    private static final String SUPORT = "OCI";

    private final Validator validator;

    private final ObjectMapper objectMapper;

    @Autowired
    public EmailOciService(Validator validator, ObjectMapper objectMapper) {
        this.validator = validator;
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean support(String platform) {
        return platform.equalsIgnoreCase(SUPORT);
    }

    @Override
    public void sendEmail(EmailDTO emailDTO) {
        try {
            EmailOciDTO oci = new EmailOciDTO(emailDTO);
            Set<ConstraintViolation<EmailOciDTO>> violations = validator.validate(oci);

            if (!violations.isEmpty()) {
                List<FildMessage> erros = violations.stream()
                        .map(v -> {
                            return new FildMessage(v.getPropertyPath().toString(), v.getMessage());
                        }).toList();
                throw new ObjectValidationException(erros);
            }

            String result = objectMapper.writeValueAsString(oci);
            logger.info(result);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
    }
}
