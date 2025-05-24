package com.viasoft.projeto.envioEmail.interfaces;

import com.viasoft.projeto.envioEmail.dtos.EmailDTO;

public interface EmailStrategy {

    boolean support(String platform);

    void sendEmail(EmailDTO emailDTO);
}
