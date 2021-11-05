package com.dojao.bff.clients;

import com.dojao.bff.extrato.ExtratoResponse;
import com.dojao.bff.pagamento.PagamentoRequest;
import com.dojao.bff.recarga.RecargaRequest;
import com.dojao.bff.transacao.TransacaoRequest;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "orquestrador", url = "${feign.client.orquestrador.url}")
public interface OrquestradorClient {

    @PostMapping("/pagamento")
    void pagamento(@RequestBody PagamentoRequest pagamentoRequest);

    @PostMapping("/transacao")
    void transacao(@RequestBody TransacaoRequest transacaoRequest);

    @PostMapping("/recarga")
    void recarga(@RequestBody RecargaRequest recargaRequest);

    @GetMapping(value = "/extrato/{idConta}", consumes = "application/json")
    List<ExtratoResponse> extrato(@PathVariable String idConta);
}
