package com.dojao.extrato.exception;

public class NotFoundException extends RuntimeException{
    private String value;
    private String message;

    public NotFoundException(String value){
        this.value = value;
        this.message = "Não existe transacões relacionadas com o cliente " + value;
    }

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
