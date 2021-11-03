package com.dojao.bff.pagamento;

import com.dojao.bff.clients.OrquestradorClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PagamentoController {

    private final OrquestradorClient orquestradorClient;

    public PagamentoController(OrquestradorClient orquestradorClient) {
        this.orquestradorClient = orquestradorClient;
    }

    @PostMapping
    @RequestMapping("/pagamento")
    public void paga(@RequestBody @Valid PagamentoRequest pagamentoRequest) {
        this.orquestradorClient.pagamento(pagamentoRequest);
    }
}
