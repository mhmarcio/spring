package com.welyab.teste.programador.springboottestebasico.core.services;

import com.welyab.teste.programador.springboottestebasico.core.exceptions.ProdutorRuralNaoEncontrado;
import com.welyab.teste.programador.springboottestebasico.core.model.Producao;
import com.welyab.teste.programador.springboottestebasico.core.model.ProdutorRural;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ProdutorRuralService {

    ProdutorRural buscarProdutorRural(String inscricao) throws ProdutorRuralNaoEncontrado;

    BigDecimal calcularProducaoPorHectare(String inscricao, LocalDate data) throws ProdutorRuralNaoEncontrado;

    List<Producao> buscarProducao(String inscricao, LocalDate dataInicio, LocalDate dataFim) throws ProdutorRuralNaoEncontrado;
}
