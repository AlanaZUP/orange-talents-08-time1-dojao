package com.dojao.extrato.consultaExtrato;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import com.google.gson.Gson;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ConsultaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Gson gson = new Gson();

    @Test
    public void deveRetornarOkETransacoes() throws Exception {
        mockMvc.perform(get("/conta/1/extrato")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andExpect(jsonPath("$.content[0].dataTransacao").value("2021-11-03T08:30:00"))
                .andExpect(jsonPath("$.pageable").exists())
                .andExpect(jsonPath("$.number").value(0))
                .andExpect(jsonPath("$.size").value(20))
                .andExpect(jsonPath("$.totalPages").value(3))
                .andExpect(jsonPath("$.totalElements").value(52))
                .andExpect(jsonPath("$.last").value(false))
                .andExpect(jsonPath("$.empty").value(false));

    }

    @Test
    public void deveRetornarOkETransacoesPagina2() throws Exception {
        mockMvc.perform(get("/conta/1/extrato?page=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andExpect(jsonPath("$.content[0].dataTransacao").value("2019-12-01T08:30:00"))
                .andExpect(jsonPath("$.pageable").exists())
                .andExpect(jsonPath("$.number").value(1))
                .andExpect(jsonPath("$.size").value(20))
                .andExpect(jsonPath("$.totalPages").value(3))
                .andExpect(jsonPath("$.totalElements").value(52))
                .andExpect(jsonPath("$.numberOfElements").value(20))
                .andExpect(jsonPath("$.last").value(false))
                .andExpect(jsonPath("$.empty").value(false));
    }


    @Test
    public void deveRetornarOkETransacoesPagina2Size5() throws Exception {
        mockMvc.perform(get("/conta/1/extrato?page=1&size=5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andExpect(jsonPath("$.content[0].dataTransacao").value("2021-06-01T08:30:00"))
                .andExpect(jsonPath("$.pageable").exists())
                .andExpect(jsonPath("$.number").value(1))
                .andExpect(jsonPath("$.size").value(5))
                .andExpect(jsonPath("$.totalPages").value(11))
                .andExpect(jsonPath("$.totalElements").value(52))
                .andExpect(jsonPath("$.numberOfElements").value(5))
                .andExpect(jsonPath("$.last").value(false))
                .andExpect(jsonPath("$.empty").value(false));
    }

    @Test
    public void deveRetornarOkETransacoesVazio() throws Exception {
        mockMvc.perform(get("/conta/1/extrato?page=11&size=5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andExpect(jsonPath("$.content[0]").doesNotExist())
                .andExpect(jsonPath("$.pageable").exists())
                .andExpect(jsonPath("$.number").value(11))
                .andExpect(jsonPath("$.size").value(5))
                .andExpect(jsonPath("$.totalPages").value(11))
                .andExpect(jsonPath("$.totalElements").value(52))
                .andExpect(jsonPath("$.numberOfElements").value(0))
                .andExpect(jsonPath("$.last").value(true))
                .andExpect(jsonPath("$.empty").value(true));
    }


    @Test
    public void deveRetornarOkETransacoesSize50() throws Exception {
        mockMvc.perform(get("/conta/1/extrato?size=52")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andExpect(jsonPath("$.pageable").exists())
                .andExpect(jsonPath("$.number").value(0))
                .andExpect(jsonPath("$.size").value(50))
                .andExpect(jsonPath("$.totalPages").value(2))
                .andExpect(jsonPath("$.totalElements").value(52))
                .andExpect(jsonPath("$.numberOfElements").value(50))
                .andExpect(jsonPath("$.last").value(false))
                .andExpect(jsonPath("$.empty").value(false));
    }

    @Test
    public void deveRetornarNotFound() throws Exception {
        mockMvc.perform(get("/conta/100/extrato")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.timeError").exists())
                .andExpect(jsonPath("$.statusCode").value(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.toString()))
                .andExpect(jsonPath("$.details").value("Não existe transacões relacionadas com o cliente 100"))
                .andExpect(jsonPath("$.errors").doesNotExist());

    }
}