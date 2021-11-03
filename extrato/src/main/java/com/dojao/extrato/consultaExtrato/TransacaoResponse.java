package com.dojao.extrato.consultaExtrato;

import com.dojao.extrato.transacao.Operacao;
import com.dojao.extrato.transacao.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private Long id;
    private Operacao operacao;
    private BigDecimal valor;
    private LocalDateTime dataTransacao;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.operacao = transacao.getOperacao();
        this.valor = transacao.getValor();
        this.dataTransacao = transacao.getDataTransacao();
    }

    public Long getId() {
        return id;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }
}
