package com.welyab.teste.programador.springboottestebasico.application.repositories;

import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProducao;
import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProduto;
import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProdutoProdutor;
import com.welyab.teste.programador.springboottestebasico.core.exceptions.ProdutoNaoEncontrado;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Repository
public class ProdutoRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public ProdutoRepository(DataSource ds) {
        jdbc = new NamedParameterJdbcTemplate(ds);
    }

    public List<TProduto> buscarProdutos(List<String> ids) {
        if (ids.isEmpty()) return Collections.emptyList();

        String sql = "" +
                " select " +
                " p.id as id, " +
                " p.nome as nome " +
                " from apl_test.tab_produto p " +
                " where p.id in (:ids) ";

        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("ids", ids);

        return jdbc.query(
                sql,
                parametros,
                BeanPropertyRowMapper.newInstance(TProduto.class)
        );
    }

    public List<TProdutoProdutor> buscarProdutosPorProdutor(String inscricao) {
        String sql = "" +
                " SELECT DISTINCT" +
                " P.ID_PRODUTO as idProduto, " +
                " PRO.NOME as nome, " +
                " FROM APL_TEST.TAB_PRODUCAO P, APL_TEST.TAB_PRODUTO PRO, APL_TEST.TAB_PRODUTOR_RURAL PR" +
                " WHERE PR.INSCRICAO = :inscricao " +
                " AND P.ID_PRODUTO = PRO.ID " +
                " AND P.ID_PRODUTOR_RURAL = PR.ID " +
                " ORDER BY PRO.NOME";

        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("inscricao", inscricao);

        return jdbc.query(
                sql,
                parametros,
                BeanPropertyRowMapper.newInstance(TProdutoProdutor.class)
        );
    }

    public void deletarProduto(String id) throws ProdutoNaoEncontrado {
        String sql = "delete " +
                     "from apl_test.tab_produto p " +
                     "where p.id = :id";
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("id", id);

        int i = jdbc.update(
                sql,
                parametros
        );

        if(i == 0) {
            throw new ProdutoNaoEncontrado(id);
        }
    }


}
