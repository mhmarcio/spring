package com.welyab.teste.programador.springboottestebasico.application.web.request;

import com.sun.istack.internal.NotNull;

public class ProdutorRuralRequest {

    @NotNull
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
