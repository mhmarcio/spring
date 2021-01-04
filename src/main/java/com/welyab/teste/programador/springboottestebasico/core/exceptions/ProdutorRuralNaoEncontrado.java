package com.welyab.teste.programador.springboottestebasico.core.exceptions;

public class ProdutorRuralNaoEncontrado extends Exception {

    private final String inscricao;

    public ProdutorRuralNaoEncontrado(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getInscricao() {
        return inscricao;
    }
}
