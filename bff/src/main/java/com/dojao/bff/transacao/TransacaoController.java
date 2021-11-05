package com.dojao.bff.transacao;

import com.dojao.bff.clients.OrquestradorClient;
import feign.FeignException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Objects;

@Api(tags = "Transações entre contas bancárias")
@RequestMapping("/transacao")
@RestController
public class TransacaoController {

    @Autowired
    private OrquestradorClient orquestradorClient;

    @PostMapping
    public void transacao(@RequestBody @Valid TransacaoRequest transacaoRequest) {
        try {
            this.orquestradorClient.transacao(transacaoRequest);
        } catch (FeignException ex) {
            HttpStatus httpStatus = HttpStatus.resolve(ex.status());
            if (Objects.isNull(httpStatus)) {
                throw ex;
            }
            throw new ResponseStatusException(httpStatus, ex.getMessage());
        }
    }
}
