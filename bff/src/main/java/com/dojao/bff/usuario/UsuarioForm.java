package com.dojao.bff.usuario;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioForm {

    @NotBlank
    private String senha;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    public UsuarioForm(String senha, String email, String nome) {
        this.senha = senha;
        this.email = email;
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Usuario toModel() {
        return new Usuario(this.senha, this.email, this.nome);
    }

    public UsernamePasswordAuthenticationToken toAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(email,senha);

    }
}
