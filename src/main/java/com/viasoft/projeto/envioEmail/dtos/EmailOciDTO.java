package com.viasoft.projeto.envioEmail.dtos;

import jakarta.validation.constraints.Size;

public class EmailOciDTO {

    @Size(max = 40, message = "E-mail destinatário: Max: 40 caracteres")
    private String recipientEmail;

    @Size(max = 50, message = "Nome destinatário. Max: 50 caracteres")
    private String recipientName;

    @Size(max = 40, message = "E-mail remetente. Max: 40 caracteres")
    private String senderEmail;

    @Size(max = 100, message = "Assunto do e-mail. Max: 100 caracteres")
    private String subject;

    @Size(max = 250, message = "Conteúdo do e-mail. Max: 250 caracteres")
    private String body;

    public EmailOciDTO() {
    }

    public EmailOciDTO(EmailDTO emailDTO) {
        recipientEmail = emailDTO.getRecipient();
        recipientName = emailDTO.getName();
        senderEmail = emailDTO.getSender();
        subject = emailDTO.getSubject();
        body = emailDTO.getContent();
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
