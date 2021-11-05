package com.dojao.bff.transacao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class TransacaoRequest {
    @NotBlank
    private String id;
    @NotNull
    private TipoTransacaoEnum tipoTransacaoEnum;
    @Positive
    @NotNull
    private BigDecimal valor;

    public TransacaoRequest(@NotBlank String id, @NotNull TipoTransacaoEnum tipoTransacaoEnum, @Positive @NotNull BigDecimal valor) {
        this.id = id;
        this.tipoTransacaoEnum = tipoTransacaoEnum;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public TipoTransacaoEnum getTipoTransacaoEnum() {
        return tipoTransacaoEnum;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
