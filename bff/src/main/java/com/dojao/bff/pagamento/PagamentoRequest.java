package com.dojao.bff.pagamento;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class PagamentoRequest {
    @NotBlank
    private String codigoDeBarras;
    @NotBlank
    private String idConta;
    @Positive
    private BigDecimal valor;

    public PagamentoRequest(@NotBlank String codigoDeBarras, @NotBlank String idConta, @Positive BigDecimal valor) {
        this.codigoDeBarras = codigoDeBarras;
        this.idConta = idConta;
        this.valor = valor;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public String getIdConta() {
        return idConta;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
