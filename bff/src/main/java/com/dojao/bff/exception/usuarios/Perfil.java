package com.dojao.bff.exception.usuarios;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Perfil implements GrantedAuthority {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nome;


    public Perfil(Long id, String nome) {
        Id = id;
        this.nome = nome;
    }

    public Long getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String getAuthority() {
        return nome;
    }
}
