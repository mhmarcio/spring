package com.welyab.teste.programador.springboottestebasico.application.web.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.welyab.teste.programador.springboottestebasico.core.model.Produto;
import com.welyab.teste.programador.springboottestebasico.core.model.ProdutorRural;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutosPorProdutorResponse {

    @JsonProperty("produtor-rural")
    private String nomeProdutor;

    @JsonProperty("inscricao")
    private String inscricao;

    @JsonProperty("produtos")
    private List<ProdutoResponse> produtoResponses;

    public ProdutosPorProdutorResponse(ProdutorRural produtorRural, List<Produto> produtos) {
        this.inscricao = produtorRural.getInscricao();
        this.nomeProdutor = produtorRural.getNome();
        this.produtoResponses = produtos.stream().map(p -> new ProdutoResponse(p)).collect(Collectors.toList());
    }


}
