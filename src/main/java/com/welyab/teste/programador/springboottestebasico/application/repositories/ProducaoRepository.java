package com.welyab.teste.programador.springboottestebasico.application.repositories;

import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProducao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ProducaoRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public ProducaoRepository(DataSource ds) {
        jdbc = new NamedParameterJdbcTemplate(ds);
    }

    public Long buscarProducao(String idProdutorRural, LocalDate data) {
        String sql = "" +
                " SELECT SUM(P.QUANTIDADE) AS QTD " +
                " FROM APL_TEST.TAB_PRODUCAO P " +
                " WHERE P.ID_PRODUTOR_RURAL = :idProdutorRural " +
                " AND P.DT_CADASTRO = :data ";

        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("idProdutorRural", idProdutorRural);
        parametros.addValue("data", data);

        return jdbc.queryForObject(sql, parametros, Long.class);
    }

    public List<TProducao> buscar(String idProdutorRural, LocalDate dataInicio, LocalDate dataFim) {
        String sql = "" +
                " SELECT " +
                " P.ID as id," +
                " P.ID_PRODUTOR_RURAL as idProdutorRural, " +
                " P.ID_PRODUTO as idProduto, " +
                " P.QUANTIDADE as quantidade, " +
                " P.DT_CADASTRO as dataCadastro " +
                " FROM APL_TEST.TAB_PRODUCAO P " +
                " WHERE P.ID_PRODUTOR_RURAL = :idProdutorRural " +
                " AND P.DT_CADASTRO >= :dataInicio " +
                " ORDER BY P.DT_CADASTRO ";

        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("idProdutorRural", idProdutorRural);
        parametros.addValue("dataInicio", dataInicio);
        parametros.addValue("dataFim", dataFim);

        return jdbc.query(
                sql,
                parametros,
                BeanPropertyRowMapper.newInstance(TProducao.class)
        );
    }
}
