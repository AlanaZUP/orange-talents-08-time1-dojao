package com.dojao.extrato.kafka;

import com.dojao.extrato.transacao.TransacaoForm;
import com.dojao.extrato.transacao.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    private final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Autowired
    private TransacaoRepository transacaoRepository;

    @org.springframework.kafka.annotation.KafkaListener(topics = "${spring.kafka.topic}")
    public void listen(TransacaoForm transacaoForm) {
        try {
//            transacaoRepository.save();

            //TODO: enriquecer log
            LOGGER.info("Leitura realizada com sucesso");
        } catch (Exception exception) {

            //TODO: enriquecer log
            LOGGER.error("Erro na hora de armazenar leitura");
        }
    }
}
