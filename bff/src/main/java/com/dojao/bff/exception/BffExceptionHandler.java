package com.dojao.bff.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;


@RestControllerAdvice
public class BffExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(BffExceptionHandler.class);

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Erros> handleResponseStatusException(ResponseStatusException ex) {

        logger.warn("Mensagem: " + ex.getMessage() + "\nCausa: " + ex.getReason());
        return ResponseEntity.status(ex.getStatus())
                .body(new Erros(LocalDateTime.now(), ex.getStatus().value(), ex.getStatus().toString(), ex.getReason()));
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<Erros> handleException(Exception ex) {
        logger.error("Mensagem: " + ex.getMessage() + "\nCausa:" + ex.getCause());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Erros(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage()));
    }

}
