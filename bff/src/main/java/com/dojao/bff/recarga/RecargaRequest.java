package com.dojao.bff.recarga;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class RecargaRequest {
    @NotBlank
    private String id;
    @NotBlank
    private String numeroTelefone;
    @NotNull
    private OperadoraEnum operadoraEnum;
    @Positive
    @NotNull
    private BigDecimal valor;

    public RecargaRequest(@NotBlank String id, @NotBlank String numeroTelefone, @NotNull OperadoraEnum operadoraEnum,
                          @Positive @NotNull BigDecimal valor) {
        this.id = id;
        this.numeroTelefone = numeroTelefone;
        this.operadoraEnum = operadoraEnum;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public OperadoraEnum getOperadoraEnum() {
        return operadoraEnum;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
