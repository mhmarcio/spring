package com.welyab.teste.programador.springboottestebasico.application.repositories;

import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProducao;
import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProduto;
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
}
