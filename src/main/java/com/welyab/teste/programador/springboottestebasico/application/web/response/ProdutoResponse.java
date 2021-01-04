package com.welyab.teste.programador.springboottestebasico.application.web.response;

import com.welyab.teste.programador.springboottestebasico.core.model.Produto;

public class ProdutoResponse {

    private String id;
    private String nome;

    public ProdutoResponse() {
    }

    public ProdutoResponse(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
