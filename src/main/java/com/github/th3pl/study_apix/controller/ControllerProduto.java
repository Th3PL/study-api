package com.github.th3pl.study_apix.controller;

import com.github.th3pl.study_apix.Model.Produto;
import com.github.th3pl.study_apix.Service.ProdutoService;
import com.github.th3pl.study_apix.dto.ProdutoRequestCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ControllerProduto {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody ProdutoRequestCreate dto) {

        Produto produto = produtoService.save(dto);
        return ResponseEntity.status(201).body(produto);
    }

    @PutMapping
    public ResponseEntity<String> update() {
        return ResponseEntity.status(200).body("Produto atualizado");
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produtos = produtoService.findAll();
        return ResponseEntity.status(200).body(produtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return produtoService.findById(id).map(p -> ResponseEntity.ok(p))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(Long id){
       boolean result = produtoService.deleteById(id);
        if (result){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
