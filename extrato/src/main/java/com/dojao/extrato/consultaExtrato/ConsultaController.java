package com.dojao.extrato.extratos.consultaExtrato;

import com.dojao.extrato.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/extratos")
public class ConsultaController {

    @Autowired
    private TransacaoRepository extratoRepository;

    @GetMapping("/{idCliente}")
    public ExtratosResponse consultaExtratos(@PathVariable("idCliente") String idCliente){

    }
}
