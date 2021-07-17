package com.welyab.teste.programador.springboottestebasico.application.web;

import com.welyab.teste.programador.springboottestebasico.application.repositories.ProdutoRepository;
import com.welyab.teste.programador.springboottestebasico.application.web.request.ProdutorRuralRequest;
import com.welyab.teste.programador.springboottestebasico.application.web.response.ProducaoPorHectareResponse;
import com.welyab.teste.programador.springboottestebasico.application.web.response.ProducaoPorIntervaloResponse;
import com.welyab.teste.programador.springboottestebasico.application.web.response.ProdutorRuralResponse;
import com.welyab.teste.programador.springboottestebasico.application.web.response.ProdutosPorProdutorResponse;
import com.welyab.teste.programador.springboottestebasico.core.exceptions.ProdutoNaoEncontrado;
import com.welyab.teste.programador.springboottestebasico.core.exceptions.ProdutorRuralNaoEncontrado;
import com.welyab.teste.programador.springboottestebasico.core.model.Producao;
import com.welyab.teste.programador.springboottestebasico.core.model.Produto;
import com.welyab.teste.programador.springboottestebasico.core.model.ProdutorRural;
import com.welyab.teste.programador.springboottestebasico.core.services.ProdutorRuralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @DeleteMapping("{code}")
    public ResponseEntity<ProdutorRuralResponse> autlizaProdutorRural(
            @PathVariable("code") String code
    ) {
        ProdutorRural produtorRural = null;
        try {
             produtoRepository.deletarProduto(code);
        } catch (ProdutoNaoEncontrado produtoNaoEncontrado) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Produto com code %s não encontrado", code)
            );
        }
        return ResponseEntity.ok().build();
    }



}
