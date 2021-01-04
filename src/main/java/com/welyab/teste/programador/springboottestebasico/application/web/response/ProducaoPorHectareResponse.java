package com.welyab.teste.programador.springboottestebasico.application.web.response;

import java.math.BigDecimal;

public class ProducaoPorHectareResponse {

    private BigDecimal producao;

    public ProducaoPorHectareResponse() {
    }

    public ProducaoPorHectareResponse(BigDecimal producao) {
        this.producao = producao;
    }

    public BigDecimal getProducao() {
        return producao;
    }

    public void setProducao(BigDecimal producao) {
        this.producao = producao;
    }
}
