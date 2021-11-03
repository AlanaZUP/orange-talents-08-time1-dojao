package com.dojao.extrato.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandle {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public StandardError handleNotFoundException(MethodArgumentNotValidException ex) {
        StandardError standardError = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString(), ex.getMessage());

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroResponse error = new ErroResponse(e.getField(), e.getRejectedValue(), message);
            standardError.addError(error);
        });

        logger.warn(standardError.toString()+"\n\nTrace: " + ex.getStackTrace());

        return standardError;
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public StandardError handleNotFoundException(RegraDeNegocioException ex) {
        logger.warn("Mensagem: "+ex.getMessage()+"\nTrace:"+ ex.getStackTrace());
        return new StandardError(LocalDateTime.now(), HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.toString(), ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public StandardError handleNotFoundException(NotFoundException ex) {
        logger.warn("Mensagem: "+ex.getMessage()+"\nTrace:"+ ex.getStackTrace());
        return new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public StandardError handleException(Exception ex) {
        logger.error("Mensagem: "+ex.getMessage()+"\nCausa:"+ ex.getCause()+"\nTrace: " + ex.getStackTrace());
        return new StandardError(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
    }
}
