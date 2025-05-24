package com.viasoft.projeto.envioEmail.services.exceptions;

import com.viasoft.projeto.envioEmail.controllers.exceptions.FildMessage;

import java.util.List;

public class ObjectValidationException extends RuntimeException {

    private final List<FildMessage> errors;

    public ObjectValidationException(List<FildMessage> errors) {
        this.errors = errors;
    }

    public List<FildMessage> getErros() {
        return errors;
    }
}
