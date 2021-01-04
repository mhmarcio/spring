package com.welyab.teste.programador.springboottestebasico.application.web.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.welyab.teste.programador.springboottestebasico.core.model.ProdutorRural;

public class ProdutorRuralResponse {

	@JsonProperty("inscricao")
	private String inscricao;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("dt-cadastro")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataCadastro;

	@JsonProperty("area-propriedade")
	private Integer areaPropriedade;

	public ProdutorRuralResponse() {
	}

	public ProdutorRuralResponse(ProdutorRural produtorRural) {
		inscricao = produtorRural.getInscricao();
		nome = produtorRural.getNome();
		inscricao = produtorRural.getInscricao();
		areaPropriedade = produtorRural.getAreaPropriedade();
		dataCadastro = produtorRural.getDataCadastro();
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
