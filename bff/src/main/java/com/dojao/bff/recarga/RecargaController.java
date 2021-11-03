package com.dojao.bff.recarga;

import com.dojao.bff.clients.OrquestradorClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RecargaController {

    private final OrquestradorClient orquestradorClient;

    public RecargaController(OrquestradorClient orquestradorClient) {
        this.orquestradorClient = orquestradorClient;
    }

    @PostMapping
    @RequestMapping("/recarga")
    public void recarga(@RequestBody @Valid RecargaRequest recargaRequest){
        this.orquestradorClient.recarga(recargaRequest);
    }
}
