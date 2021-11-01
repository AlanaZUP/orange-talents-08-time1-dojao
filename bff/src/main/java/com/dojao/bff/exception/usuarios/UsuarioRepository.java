package com.dojao.bff.exception.usuarios;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository <Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}

