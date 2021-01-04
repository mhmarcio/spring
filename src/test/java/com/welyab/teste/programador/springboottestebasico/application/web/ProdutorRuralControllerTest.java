package com.welyab.teste.programador.springboottestebasico.application.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutorRuralControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void consultarProducaoPorIntervaloDataDeveRetornarProducaoNoIntervaloEspecificado() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/produtor-rural/{inscricao}/producao", "987654321")
                        .param("data-inicio", "2020-09-02")
                        .param("data-fim", "2020-09-03")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.dt-inicio", Matchers.is("2020-09-02")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dt-fim", Matchers.is("2020-09-03")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.producoes", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.producoes[0].dt-cadastro", Matchers.is("2020-09-02")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.producoes[1].dt-cadastro", Matchers.is("2020-09-03")));
    }
}
