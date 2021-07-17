package com.welyab.teste.programador.springboottestebasico.application.repositories;

import java.util.Optional;

import javax.sql.DataSource;

import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProdutoProdutor;
import com.welyab.teste.programador.springboottestebasico.core.exceptions.ProdutorRuralNaoEncontrado;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProdutorRural;

@Repository
public class ProdutorRuralRepository {

	private final NamedParameterJdbcTemplate jdbc;

	public ProdutorRuralRepository(DataSource ds) {
		jdbc = new NamedParameterJdbcTemplate(ds);
	}

	public Optional<TProdutorRural> buscarPorInscricao(String inscricao) {
		String sql = "select " +
				" id as id, " +
				" inscricao as inscricao, " +
				" nome as nome, " +
				" dt_cadastro as dataCadastro, " +
				" area_propriedade as areaPropriedade " +
				" from apl_test.tab_produtor_rural p " +
				" where p.inscricao = :inscricao";
		MapSqlParameterSource parametros = new MapSqlParameterSource();
		parametros.addValue("inscricao", inscricao);
		try {
			return Optional.ofNullable(
				jdbc.queryForObject(
					sql,
					parametros,
					BeanPropertyRowMapper.newInstance(TProdutorRural.class)
				)
			);
		} catch (IncorrectResultSizeDataAccessException e) {
			if (e.getActualSize() == 0) {
				return Optional.empty();
			}
			throw e;
		}
	}


	public void atualizaProdutor(String nome, String inscricao) throws ProdutorRuralNaoEncontrado {
		String sql = "update " +
					 " apl_test.tab_produtor_rural p " +
					 " set p.nome = :nome " +
					 " where p.inscricao = :inscricao";
		MapSqlParameterSource parametros = new MapSqlParameterSource();
		parametros.addValue("nome", nome);
		parametros.addValue("inscricao", inscricao);
		int i = jdbc.update(
				sql,
				parametros
		);

		if(i == 0) {
			throw new ProdutorRuralNaoEncontrado(inscricao);
		}
	}
}
