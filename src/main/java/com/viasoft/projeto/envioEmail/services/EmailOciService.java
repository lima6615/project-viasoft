package com.viasoft.projeto.envioEmail.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viasoft.projeto.envioEmail.dtos.EmailDTO;
import com.viasoft.projeto.envioEmail.dtos.EmailOciDTO;
import com.viasoft.projeto.envioEmail.interfaces.EmailStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailOciService implements EmailStrategy {

    private static final Logger logger = LoggerFactory.getLogger(EmailOciService.class);

    private static final String SUPORT = "OCI";

    private final ObjectMapper objectMapper;

    @Autowired
    public EmailOciService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean support(String platform) {
        return platform.equalsIgnoreCase(SUPORT);
    }

    @Override
    public void sendEmail(EmailDTO emailDTO) {
        try {
            String result = objectMapper.writeValueAsString(new EmailOciDTO(emailDTO));
            logger.info(result);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
    }
}
