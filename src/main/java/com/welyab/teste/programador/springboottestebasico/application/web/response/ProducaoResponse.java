package com.welyab.teste.programador.springboottestebasico.application.web.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.welyab.teste.programador.springboottestebasico.core.model.Producao;

import java.time.LocalDate;

public class ProducaoResponse {

    private ProdutoResponse produto;
    private Long quantidade;

    @JsonProperty("dt-cadastro")
    private LocalDate dataCadastro;

    public ProducaoResponse() {
    }

    public ProducaoResponse(Producao producao) {
        this.produto = new ProdutoResponse(producao.getProduto());
        this.quantidade = producao.getQuantidade();
        this.dataCadastro = producao.getDataCadastro();
    }

    public ProdutoResponse getProduto() {
        return produto;
    }

    public void setProduto(ProdutoResponse produto) {
        this.produto = produto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
