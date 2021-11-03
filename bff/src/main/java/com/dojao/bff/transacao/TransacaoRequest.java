package com.dojao.bff.transacao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TransacaoRequest {
    @NotBlank
    private String id;
    @NotNull
    private TipoTransacaoEnum tipoTransacaoEnum;

    public TransacaoRequest(@NotBlank String id, @NotNull TipoTransacaoEnum tipoTransacaoEnum) {
        this.id = id;
        this.tipoTransacaoEnum = tipoTransacaoEnum;
    }

    public String getId() {
        return id;
    }

    public TipoTransacaoEnum getTipoTransacaoEnum() {
        return tipoTransacaoEnum;
    }
}
