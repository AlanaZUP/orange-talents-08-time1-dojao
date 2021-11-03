package com.dojao.extrato.consultaExtrato;

import com.dojao.extrato.exception.NotFoundException;
import com.dojao.extrato.transacao.Transacao;
import com.dojao.extrato.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<?> consultaExtratos(@PathVariable("idCliente") String idCliente, @PageableDefault(page = 0, size = 20, sort = "dataTransacao", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Transacao> pageTransacoes = transacaoRepository.findByIdClienteOrderByDataTransacaoDesc(idCliente, pageable);

        if(pageTransacoes.getTotalElements() <= 0)
            throw new NotFoundException(idCliente);

        Page<TransacaoResponse> pageTransacoesDto = pageTransacoes.map(TransacaoResponse::new);

        return ResponseEntity.ok(pageTransacoesDto);
    }
}
