package com.dojao.extrato.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoForm {

    private String idCliente;
    private LocalDateTime dataTransacao;
    private BigDecimal valor;
    private Operacao tipoTransacao;


    @Deprecated
    public TransacaoForm() {
    }

    public TransacaoForm(BigDecimal valor, Operacao tipoTransacao) {
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
    }

    public Transacao toModel() {
        return new Transacao(this.idCliente, this.tipoTransacao, this.valor, this.dataTransacao);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Operacao getTipoTransacao() {
        return tipoTransacao;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }
}
