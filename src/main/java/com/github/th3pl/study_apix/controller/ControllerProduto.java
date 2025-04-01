package com.github.th3pl.study_apix.controller;

import com.github.th3pl.study_apix.Model.Produto;
import com.github.th3pl.study_apix.Service.ProdutoService;
import com.github.th3pl.study_apix.dto.ProdutoRequestCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Produto find() {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(){
        return ResponseEntity.status(204).build();
    }


}
