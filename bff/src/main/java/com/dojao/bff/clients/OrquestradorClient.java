package com.dojao.bff.clients;

import com.dojao.bff.pagamento.PagamentoRequest;
import com.dojao.bff.recarga.RecargaRequest;
import com.dojao.bff.transacao.TransacaoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "orquestrador", url = "${feign.client.url.orquestrador}")
public interface OrquestradorClient {

    @PostMapping
    String pagamento(@RequestBody PagamentoRequest pagamentoRequest);

    @PostMapping
    String transacao(@RequestBody TransacaoRequest transacaoRequest);

    @PostMapping
    String recarga(@RequestBody RecargaRequest recargaRequest);
}
