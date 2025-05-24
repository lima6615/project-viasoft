package com.viasoft.projeto.envioEmail.controllers.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StandardError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
    private String message;

    private List<FildMessage> listError = new ArrayList<>();

    public StandardError() {
    }

    public StandardError(Instant timestamp, Integer status, String error, String path, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FildMessage> getListError() {
        return listError;
    }

    public void addErro(FildMessage erro) {
        this.listError.add(erro);
    }
}
