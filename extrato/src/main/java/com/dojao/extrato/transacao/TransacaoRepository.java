package com.dojao.extrato.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    Page<List<Transacao>> findByIdClienteOrderByDataTransacaoDesc(String idCliente, Pageable pageable);
}
