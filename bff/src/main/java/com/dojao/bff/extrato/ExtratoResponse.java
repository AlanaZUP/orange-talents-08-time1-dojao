package com.dojao.bff.extrato;

import java.math.BigDecimal;

public class ExtratoResponse {

    private Long id;
    private String operacao;
    private BigDecimal valor;
    private String dataTransacao;

    public Long getId() {
        return id;
    }

    public String getOperacao() {
        return operacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }
}