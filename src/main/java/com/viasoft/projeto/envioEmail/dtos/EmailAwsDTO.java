package com.viasoft.projeto.envioEmail.dtos;

import jakarta.validation.constraints.Max;

public class EmailAwsDTO {

    @Max(value = 45, message = "E-mail destinatário: Max: 45 caracteres")
    private String recipient;

    @Max(value = 10, message = "Nome destinatário. Max: 60 caracteres")
    private String recipientName;

    @Max(value = 45, message = "E-mail remetente. Max: 45 caracteres")
    private String sender;

    @Max(value = 120, message = "Assunto do e-mail. Max: 120 caracteres")
    private String subject;

    @Max(value = 256, message = "Conteúdo do e-mail. Max: 256 caracteres")
    private String content;

    public EmailAwsDTO() {
    }

    public EmailAwsDTO(EmailDTO emailDTO) {
        recipient = emailDTO.getRecipient();
        recipientName = emailDTO.getName();
        sender = emailDTO.getSender();
        subject = emailDTO.getSubject();
        content = emailDTO.getContent();
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
