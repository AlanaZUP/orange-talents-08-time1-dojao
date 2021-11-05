package com.dojao.bff.pagamento;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class PagamentoRequest {
    @NotBlank
    private String codigoDeBarras;
    @NotNull
    @Positive
    private int idConta;
    @Positive
    @NotNull
    private BigDecimal valor;

    public PagamentoRequest(@NotBlank String codigoDeBarras, @NotNull @Positive int idConta, @Positive BigDecimal valor) {
        this.codigoDeBarras = codigoDeBarras;
        this.idConta = idConta;
        this.valor = valor;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public int getIdConta() {
        return idConta;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
