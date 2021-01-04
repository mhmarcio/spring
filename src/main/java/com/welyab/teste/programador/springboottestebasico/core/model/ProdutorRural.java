package com.welyab.teste.programador.springboottestebasico.core.model;

import java.time.LocalDate;

public class ProdutorRural {

    private String id;
    private String inscricao;
    private String nome;
    private LocalDate dataCadastro;
    private Integer areaPropriedade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getAreaPropriedade() {
        return areaPropriedade;
    }

    public void setAreaPropriedade(Integer areaPropriedade) {
        this.areaPropriedade = areaPropriedade;
    }
}
