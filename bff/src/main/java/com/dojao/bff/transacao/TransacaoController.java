package com.dojao.bff.transacao;

import com.dojao.bff.clients.OrquestradorClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TransacaoController {

    private final OrquestradorClient orquestradorClient;

    public TransacaoController(OrquestradorClient orquestradorClient) {
        this.orquestradorClient = orquestradorClient;
    }

    @PostMapping
    @RequestMapping("/transacao")
    public void transacao(@RequestBody @Valid TransacaoRequest transacaoRequest){
        this.orquestradorClient.transacao(transacaoRequest);
    }
}
