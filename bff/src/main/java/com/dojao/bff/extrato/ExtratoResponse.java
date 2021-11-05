package com.dojao.bff.extrato;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExtratoResponse {

    private Long id;
    private String operacao;
    private BigDecimal valor;
    //TODO
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime dataTransacao;

    public Long getId() {
        return id;
    }

    public String getOperacao() {
        return operacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }
}