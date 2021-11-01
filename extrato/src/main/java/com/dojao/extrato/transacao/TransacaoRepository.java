package com.dojao.extrato.extratos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExtratoRepository extends JpaRepository<Extrato, Long> {

    List<Extrato> findByIdCliente(String idCliente);
}
