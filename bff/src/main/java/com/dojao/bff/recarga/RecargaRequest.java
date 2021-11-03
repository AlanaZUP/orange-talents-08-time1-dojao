package com.dojao.bff.recarga;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RecargaRequest {
    @NotBlank
    private String id;
    @NotBlank
    private String numeroTelefone;
    @NotNull
    private OperadoraEnum operadoraEnum;

    public RecargaRequest(@NotBlank String id, @NotBlank String numeroTelefone, @NotNull OperadoraEnum operadoraEnum) {
        this.id = id;
        this.numeroTelefone = numeroTelefone;
        this.operadoraEnum = operadoraEnum;
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
}
