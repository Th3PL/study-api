package com.github.th3pl.study_apix;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ControllerProduto {

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Produto produto) {
        return ResponseEntity.status(201).body("Produto cadastrado");
    }

    @PutMapping
    public ResponseEntity<String> update() {
        return ResponseEntity.status(200).body("Produto atualizado");
    }

    @GetMapping
    public String find() {
        return "Maçã";
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(){
        return ResponseEntity.status(204).build();
    }
}
