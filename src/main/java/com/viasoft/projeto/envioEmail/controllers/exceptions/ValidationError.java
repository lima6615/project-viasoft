package com.viasoft.projeto.envioEmail.controllers.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FildMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path, String message) {
        super(timestamp, status, error, path, message);
    }

    public List<FildMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.add(new FildMessage(fieldName, message));
    }
}
