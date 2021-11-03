package com.dojao.extrato.exception;

public class ErroResponse {

    private String field;
    private Object value;
    private String message;

    public ErroResponse(String field, Object value, String message) {
        this.field = field;
        this.value = value;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public Object getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
