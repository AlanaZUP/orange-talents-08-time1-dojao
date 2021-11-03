package com.dojao.extrato.exception;

import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public class StandardError{

    private LocalDateTime timeError;
    private Integer statusCode;
    private String status;
    private String details;
    private List<ErroResponse> errors;

    public StandardError(LocalDateTime timeError, Integer statusCode, String status, String details) {
        this.timeError = timeError;
        this.statusCode = statusCode;
        this.status = status;
        this.details = details;
    }

    public void addError(ErroResponse error) {
        this.errors.add(error);
    }

    public LocalDateTime getTimeError() {
        return timeError;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public List<ErroResponse> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "StandardError{" +
                "timeError=" + timeError +
                ", statusCode=" + statusCode +
                ", status='" + status + '\'' +
                ", details='" + details + '\'' +
                ", errors=" + errors +
                '}';
    }
}
