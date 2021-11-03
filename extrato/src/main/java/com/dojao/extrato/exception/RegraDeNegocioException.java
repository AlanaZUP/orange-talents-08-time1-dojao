package com.dojao.extrato.exception;

public class RegraDeNegocioException extends RuntimeException{
    private String message;
    private String field;
    private Object value;

    public RegraDeNegocioException(String message, String field, Object value){
        this.message = message;
        this.field = field;
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }

    public Object getValue() {
        return value;
    }
}
