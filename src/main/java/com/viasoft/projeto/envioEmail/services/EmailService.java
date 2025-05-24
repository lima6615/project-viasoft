package com.viasoft.projeto.envioEmail.services;

import com.viasoft.projeto.envioEmail.dtos.EmailDTO;
import com.viasoft.projeto.envioEmail.interfaces.EmailStrategy;
import com.viasoft.projeto.envioEmail.services.exceptions.NotSupportPlatformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Value("${mail.integracao}")
    private String platform;

    private final List<EmailStrategy> emailSenderStrategies;

    @Autowired
    public EmailService(List<EmailStrategy> emailStrategy) {
        this.emailSenderStrategies = emailStrategy;
    }

    public void sendEmail(EmailDTO emailDTO) {
        for (EmailStrategy strategy : emailSenderStrategies) {
            if (strategy.support(platform)) {
                strategy.sendEmail(emailDTO);
                return;
            }
        }
         throw new NotSupportPlatformException("Não há suporte disponível para a plataforma = " + platform);
    }
}
