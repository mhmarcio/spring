package com.welyab.teste.programador.springboottestebasico.application.web.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.welyab.teste.programador.springboottestebasico.core.model.Producao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProducaoPorIntervaloResponse {

    @JsonProperty("dt-inicio")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInicio;

    @JsonProperty("dt-fim")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFim;

    private List<ProducaoResponse> producoes;

    public ProducaoPorIntervaloResponse() {
    }

    public ProducaoPorIntervaloResponse(List<Producao> producoes, LocalDate dataInicio, LocalDate dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.producoes = producoes.stream().map(ProducaoResponse::new).collect(Collectors.toList());
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public List<ProducaoResponse> getProducoes() {
        return producoes;
    }

    public void setProducoes(List<ProducaoResponse> producoes) {
        this.producoes = producoes;
    }
}
