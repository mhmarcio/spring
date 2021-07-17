package com.welyab.teste.programador.springboottestebasico.application.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.welyab.teste.programador.springboottestebasico.application.repositories.ProducaoRepository;
import com.welyab.teste.programador.springboottestebasico.application.repositories.ProdutoRepository;
import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProducao;
import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProduto;
import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProdutoProdutor;
import com.welyab.teste.programador.springboottestebasico.application.web.request.ProdutorRuralRequest;
import com.welyab.teste.programador.springboottestebasico.core.model.Producao;
import com.welyab.teste.programador.springboottestebasico.core.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import com.welyab.teste.programador.springboottestebasico.application.repositories.ProdutorRuralRepository;
import com.welyab.teste.programador.springboottestebasico.application.repositories.tabelas.TProdutorRural;
import com.welyab.teste.programador.springboottestebasico.core.exceptions.ProdutorRuralNaoEncontrado;
import com.welyab.teste.programador.springboottestebasico.core.model.ProdutorRural;
import com.welyab.teste.programador.springboottestebasico.core.services.ProdutorRuralService;

@Service
public class ProdutorRuralServiceImpl implements ProdutorRuralService {

    @Autowired
    private ProdutorRuralRepository produtorRuralRepository;

    @Autowired
    private ProducaoRepository producaoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public ProdutorRural buscarProdutorRural(String inscricao) throws ProdutorRuralNaoEncontrado {
        Preconditions.checkNotNull(inscricao, "inscricao");
        Optional<TProdutorRural> optionalProdutorRural = produtorRuralRepository.buscarPorInscricao(inscricao);
        if (!optionalProdutorRural.isPresent()) {
            throw new ProdutorRuralNaoEncontrado(inscricao);
        }
        return toProdutorRural(optionalProdutorRural.get());
    }

    @Override
    public BigDecimal calcularProducaoPorHectare(String inscricao, LocalDate data) throws ProdutorRuralNaoEncontrado {
        Optional<TProdutorRural> opProdutorRural = produtorRuralRepository.buscarPorInscricao(inscricao);
        if (!opProdutorRural.isPresent()) {
            throw new ProdutorRuralNaoEncontrado(inscricao);
        }
        TProdutorRural produtorRural = opProdutorRural.get();
        Long totalProducao = producaoRepository.buscarProducao(produtorRural.getId(), data);
        return BigDecimal.valueOf(totalProducao == null ? 0L : totalProducao).divide(
                BigDecimal.valueOf(produtorRural.getAreaPropriedade()),
                2,
                RoundingMode.HALF_UP
        );
    }

    @Override
    public List<Producao> buscarProducao(String inscricao, LocalDate dataInicio, LocalDate dataFim) throws ProdutorRuralNaoEncontrado {
        Optional<TProdutorRural> opProdutorRural = produtorRuralRepository.buscarPorInscricao(inscricao);
        if (!opProdutorRural.isPresent()) {
            throw new ProdutorRuralNaoEncontrado(inscricao);
        }
        TProdutorRural produtorRural = opProdutorRural.get();
        List<TProducao> tProducoes = producaoRepository.buscar(produtorRural.getId(), dataInicio, dataFim);
        Map<String, TProduto> produtosPorId = produtoRepository
                .buscarProdutos(
                        tProducoes.stream()
                                .map(TProducao::getIdProduto)
                                .distinct()
                                .collect(Collectors.toList())
                )
                .stream().collect(Collectors.toMap(TProduto::getId, Function.identity()));
        return tProducoes
                .stream()
                .map(p -> toProducao(p, produtosPorId.get(p.getIdProduto())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Produto> buscarProdutosPorProdutor(String idinscricao) throws ProdutorRuralNaoEncontrado {
        ProdutorRural produtorRural = buscarProdutorRural(idinscricao);
        List<TProdutoProdutor> producoes = produtoRepository.buscarProdutosPorProdutor(produtorRural.getInscricao());
        return producoes.stream().map(p -> toProduto(p)).collect(Collectors.toList());
    }

    @Override
    public ProdutorRural atualizaProdutorRural(ProdutorRuralRequest produtorRuralRequest, String inscricao) throws ProdutorRuralNaoEncontrado {
        Preconditions.checkNotNull(inscricao, "inscricao");
        produtorRuralRepository.atualizaProdutor(produtorRuralRequest.getNome(), inscricao);
        Optional<TProdutorRural> optionalProdutorRural = produtorRuralRepository.buscarPorInscricao(inscricao);
        return toProdutorRural(optionalProdutorRural.get());
    }

    private Producao toProducao(TProducao tProducao, TProduto tProduto) {
        Producao producao = new Producao();
        producao.setProduto(toProduto(tProduto));
        producao.setDataCadastro(tProducao.getDataCadastro());
        producao.setQuantidade(tProducao.getQuantidade());
        return producao;
    }

    private Produto toProduto(TProduto tProduto) {
        Produto produto = new Produto();
        produto.setId(tProduto.getId());
        produto.setNome(tProduto.getNome());
        return produto;
    }

    private Produto toProduto(TProdutoProdutor tProdutoProdutor) {
        Produto produto = new Produto();
        produto.setId(tProdutoProdutor.getIdProduto());
        produto.setNome(tProdutoProdutor.getNome());
        return produto;
    }

    private ProdutorRural toProdutorRural(TProdutorRural t) {
        ProdutorRural produtorRural = new ProdutorRural();
        produtorRural.setNome(t.getNome());
        produtorRural.setDataCadastro(t.getDataCadastro());
        produtorRural.setInscricao(t.getInscricao());
        produtorRural.setAreaPropriedade(t.getAreaPropriedade());
        return produtorRural;
    }
}
