package com.welyab.teste.programador.springboottestebasico.application.web;

import com.welyab.teste.programador.springboottestebasico.application.web.request.ProdutorRuralRequest;
import com.welyab.teste.programador.springboottestebasico.application.web.response.ProducaoPorHectareResponse;
import com.welyab.teste.programador.springboottestebasico.application.web.response.ProducaoPorIntervaloResponse;
import com.welyab.teste.programador.springboottestebasico.application.web.response.ProdutosPorProdutorResponse;
import com.welyab.teste.programador.springboottestebasico.core.model.Producao;
import com.welyab.teste.programador.springboottestebasico.core.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.welyab.teste.programador.springboottestebasico.application.web.response.ProdutorRuralResponse;
import com.welyab.teste.programador.springboottestebasico.core.exceptions.ProdutorRuralNaoEncontrado;
import com.welyab.teste.programador.springboottestebasico.core.model.ProdutorRural;
import com.welyab.teste.programador.springboottestebasico.core.services.ProdutorRuralService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("produtor-rural")
public class ProdutorRuralController {

    @Autowired
    private ProdutorRuralService produtorRuralService;

    @GetMapping(
            path = "{inscricao}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProdutorRuralResponse> buscarProdutorRural(
            @PathVariable("inscricao") String inscricao
    ) {
        ProdutorRural produtorRural = null;
        try {
            produtorRural = produtorRuralService.buscarProdutorRural(inscricao);
        } catch (ProdutorRuralNaoEncontrado produtorRuralNaoEncontrado) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Produtor rural com inscrição %s não encontrado", inscricao)
            );
        }
        ProdutorRuralResponse response = new ProdutorRuralResponse(produtorRural);
        return ResponseEntity.ok(response);
    }

    @PutMapping(
            path = "{inscricao}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProdutorRuralResponse> autlizaProdutorRural(
            @PathVariable("inscricao") String inscricao,
            @RequestBody @Validated ProdutorRuralRequest produtorRuralRequest
            ) {
        ProdutorRural produtorRural = null;
        try {
            produtorRural = produtorRuralService.atualizaProdutorRural(produtorRuralRequest, inscricao);
        } catch (ProdutorRuralNaoEncontrado produtorRuralNaoEncontrado) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Produtor rural com inscrição %s não encontrado", inscricao)
            );
        }
        ProdutorRuralResponse response = new ProdutorRuralResponse(produtorRural);
        return ResponseEntity.ok(response);
    }

    @GetMapping(
            path = "{inscricao}/producao",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProducaoPorIntervaloResponse> consultarProducaoPorIntervaloData(
            @PathVariable("inscricao") String inscricao,
            @RequestParam("data-inicio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicio,
            @RequestParam("data-fim") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFim
    ) {
        List<Producao> producoes = null;
        try {
            producoes = produtorRuralService.buscarProducao(inscricao, dataInicio, dataFim);
        } catch (ProdutorRuralNaoEncontrado produtorRuralNaoEncontrado) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Produtor rural com inscrição %s não encontrado", inscricao)
            );
        }
        ProducaoPorIntervaloResponse response = new ProducaoPorIntervaloResponse(
                producoes,
                dataInicio,
                dataFim
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping(
            path = "{inscricao}/producao/por-hectare",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProducaoPorHectareResponse> consultarProducaoPorHectareNaData(
            @PathVariable("inscricao") String inscricao,
            @RequestParam("data") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data
    ) throws ProdutorRuralNaoEncontrado {
        BigDecimal producao = null;
        try {
            producao = produtorRuralService.calcularProducaoPorHectare(inscricao, data);
        } catch (ProdutorRuralNaoEncontrado e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Produtor rural com inscrição %s não encontrado", inscricao)
            );
        }
        ProducaoPorHectareResponse response = new ProducaoPorHectareResponse(producao);
        return ResponseEntity.ok(response);
    }

    @GetMapping(
            path = "{inscricao}/produtos",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProdutosPorProdutorResponse> consultarProdutos(
            @PathVariable("inscricao") String inscricao
    ) throws ProdutorRuralNaoEncontrado {
        ProdutorRural produtorRural;
        List<Produto> listaProdutos;
        try {
            produtorRural = produtorRuralService.buscarProdutorRural(inscricao);
            listaProdutos = produtorRuralService.buscarProdutosPorProdutor(inscricao);
        } catch (ProdutorRuralNaoEncontrado e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Produtor rural com inscrição %s não encontrado", inscricao)
            );
        }
        ProdutosPorProdutorResponse response = new ProdutosPorProdutorResponse(produtorRural,listaProdutos);
        return ResponseEntity.ok(response);
    }
    

}
