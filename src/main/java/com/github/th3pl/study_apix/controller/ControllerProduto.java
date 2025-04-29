package com.github.th3pl.study_apix.controller;

import com.github.th3pl.study_apix.Model.Produto;
import com.github.th3pl.study_apix.Service.ProdutoService;
import com.github.th3pl.study_apix.dto.ProdutoRequestCreate;
import com.github.th3pl.study_apix.dto.ProdutoRequestUpdate;
import com.github.th3pl.study_apix.dto.ProdutoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ControllerProduto {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponse> create(@RequestBody ProdutoRequestCreate dto) {
        return ResponseEntity.status(201).body(new ProdutoResponse().toDto(produtoService.save(dto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProdutoResponse> update(@PathVariable Long id,
                                                  @RequestBody ProdutoRequestUpdate dto) {
        return produtoService.update(id, dto)
                .map(produto ->  new ProdutoResponse().toDto(produto)
                ).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> findAll() {
        return ResponseEntity.ok(
                produtoService
                        .findAll()
                        .stream()
                        .map(produto -> {
                            return new ProdutoResponse().toDto(produto);
                        })
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {
        return produtoService.findById(id).map(produto -> {
                    return new ProdutoResponse().toDto(produto);
                }).map(ResponseEntity::ok)
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
