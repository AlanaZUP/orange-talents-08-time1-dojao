package com.dojao.bff.recarga;

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

@RestController
@Api(tags = "Recarga")
@RequestMapping("/recarga")
public class RecargaController {

    @Autowired
    private OrquestradorClient orquestradorClient;

    @PostMapping
    public void recarga(@RequestBody @Valid RecargaRequest recargaRequest) {
        try {
            this.orquestradorClient.recarga(recargaRequest);
        } catch (FeignException ex) {
            HttpStatus httpStatus = HttpStatus.resolve(ex.status());
            if (Objects.isNull(httpStatus)) {
                throw ex;
            }
            throw new ResponseStatusException(httpStatus, ex.getMessage());
        }
    }
}
