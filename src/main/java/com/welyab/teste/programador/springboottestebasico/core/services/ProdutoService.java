package com.welyab.teste.programador.springboottestebasico.core.services;

import com.welyab.teste.programador.springboottestebasico.core.exceptions.ProdutoNaoEncontrado;

public interface ProdutoService {

    void deletarProduto(String code) throws ProdutoNaoEncontrado;
}
