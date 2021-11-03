package com.dojao.extrato.consultaExtrato;

import com.dojao.extrato.transacao.Transacao;
import com.dojao.extrato.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/conta")
public class ConsultaController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("/{idCliente}/extrato")
    public ResponseEntity<?> consultaExtratos(@PathVariable("idCliente") String idCliente, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "20") Integer size ){
        Pageable pageable = PageRequest.of(page, size, Sort.by("dataTransacao").descending());
        Page<List<Transacao>> transacoes = transacaoRepository.findByIdClienteOrderByDataTransacaoDesc(idCliente, pageable);

        if(transacoes.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foram encontrada transações para o cliente selecionado");

        return ResponseEntity.ok(transacoes);
    }
}
