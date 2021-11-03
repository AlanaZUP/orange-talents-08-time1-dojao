package com.dojao.extrato.transacao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String idCliente;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Operacao operacao;

    @NotNull
    @Positive
    @Column(nullable = false)
    private BigDecimal valor;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dataTransacao;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String idCliente, Operacao operacao, BigDecimal valor, LocalDateTime dataTransacao) {
        this.idCliente = idCliente;
        this.operacao = operacao;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
    }

    public Long getId() {
        return id;
    }

    public String getIdCliente() {
        return idCliente;
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
