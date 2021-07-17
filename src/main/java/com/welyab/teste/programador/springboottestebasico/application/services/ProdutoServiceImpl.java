package com.welyab.teste.programador.springboottestebasico.application.services;

import com.google.common.base.Preconditions;
import com.welyab.teste.programador.springboottestebasico.application.repositories.ProducaoRepository;
import com.welyab.teste.programador.springboottestebasico.application.repositories.ProdutoRepository;
import com.welyab.teste.programador.springboottestebasico.application.repositories.ProdutorRuralRepository;
import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProducao;
import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProduto;
import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProdutoProdutor;
import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProdutorRural;
import com.welyab.teste.programador.springboottestebasico.application.web.request.ProdutorRuralRequest;
import com.welyab.teste.programador.springboottestebasico.core.exceptions.ProdutoNaoEncontrado;
import com.welyab.teste.programador.springboottestebasico.core.exceptions.ProdutorRuralNaoEncontrado;
import com.welyab.teste.programador.springboottestebasico.core.model.Producao;
import com.welyab.teste.programador.springboottestebasico.core.model.Produto;
import com.welyab.teste.programador.springboottestebasico.core.model.ProdutorRural;
import com.welyab.teste.programador.springboottestebasico.core.services.ProdutoService;
import com.welyab.teste.programador.springboottestebasico.core.services.ProdutorRuralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void deletarProduto(String code) throws ProdutoNaoEncontrado {
        produtoRepository.deletarProduto(code);
    }
}
