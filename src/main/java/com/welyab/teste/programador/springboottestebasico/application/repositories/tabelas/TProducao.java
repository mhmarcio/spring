package com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas;

import java.time.LocalDate;

public class TProducao {

    private String id;
    private String idProdutorRural;
    private String idProduto;
    private Long quantidade;
    private LocalDate dataCadastro;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProdutorRural() {
        return idProdutorRural;
    }

    public void setIdProdutorRural(String idProdutorRural) {
        this.idProdutorRural = idProdutorRural;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
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
