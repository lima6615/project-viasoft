package com.viasoft.projeto.envioEmail.controllers.exceptions;

import com.viasoft.projeto.envioEmail.services.exceptions.NotSupportPlatformException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler(NotSupportPlatformException.class)
    public ResponseEntity<StandardError> resourceNotSupportPlatform(NotSupportPlatformException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String error = "Erro na plataforma";
        StandardError err = new StandardError(Instant.now(), status.value(), error, request.getRequestURI(), e.getMessage());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> resourceNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String error = "Requisição não validada";
        ValidationError err = new ValidationError(Instant.now(), status.value(), error, request.getRequestURI(), e.getMessage());

        for (FieldError field : e.getBindingResult().getFieldErrors()) {
            err.addError(field.getField(), field.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(err);
    }
}
