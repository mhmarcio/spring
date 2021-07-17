package com.welyab.teste.programador.springboottestebasico.core.exceptions;

public class ProdutoNaoEncontrado extends Exception {

    private final String code;

    public ProdutoNaoEncontrado(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
