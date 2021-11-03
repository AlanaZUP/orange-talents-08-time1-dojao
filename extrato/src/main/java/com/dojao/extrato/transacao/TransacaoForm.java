package com.dojao.extrato.transacao;

import java.math.BigDecimal;

public class TransacaoForm {

    private BigDecimal valor;
    private String tipoTransacao;

    @Deprecated
    public TransacaoForm() {
    }

    public TransacaoForm(BigDecimal valor, String tipoTransacao) {
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }
}
