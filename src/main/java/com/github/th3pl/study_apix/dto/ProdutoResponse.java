package com.github.th3pl.study_apix.dto;

import com.github.th3pl.study_apix.Model.Produto;

public class ProdutoResponse {
    private Long id;
    private String nome;



    public ProdutoResponse toDto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
