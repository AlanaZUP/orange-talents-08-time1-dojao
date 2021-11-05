package com.dojao.bff.extrato;

import com.dojao.bff.clients.OrquestradorClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/extrato")
class ExtratoController {

    @Autowired
    private OrquestradorClient orquestradorClient;

    @GetMapping("/{idConta}")
    ResponseEntity<?> consulta(@PathVariable String idConta) {
        try {
            final List<ExtratoResponse> list = this.orquestradorClient.extrato(idConta);
            final PageImpl<ExtratoResponse> page = new PageImpl<>(list);
            return ResponseEntity.ok(page);
        } catch (FeignException ex) {
            HttpStatus httpStatus = HttpStatus.resolve(ex.status());
            if (Objects.isNull(httpStatus)) {
                throw ex;
            }
            throw new ResponseStatusException(httpStatus, ex.getMessage());
        }
    }
}
