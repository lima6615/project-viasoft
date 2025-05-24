package com.viasoft.projeto.envioEmail.controllers.exceptions;

import com.viasoft.projeto.envioEmail.services.exceptions.NotSupportPlatformException;
import com.viasoft.projeto.envioEmail.services.exceptions.ObjectValidationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler(NotSupportPlatformException.class)
    public ResponseEntity<StandardError> resourceNotSupportPlatform(NotSupportPlatformException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String error = "Erro na plataforma";
        StandardError standardError = new StandardError(Instant.now(), status.value(), error, request.getRequestURI(), e.getMessage());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(ObjectValidationException.class)
    public ResponseEntity<StandardError> resourceNotValidException(ObjectValidationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String error = "Erro de validação";
        StandardError standardError = new StandardError(Instant.now(), status.value(), error, request.getRequestURI(), e.getMessage());
        e.getErros().forEach(standardError::addErro);
        return ResponseEntity.status(status).body(standardError);
    }
}
