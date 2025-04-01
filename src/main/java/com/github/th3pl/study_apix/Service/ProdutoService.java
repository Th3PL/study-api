package com.github.th3pl.study_apix.Service;

import com.github.th3pl.study_apix.Model.Produto;
import com.github.th3pl.study_apix.dto.ProdutoRequestCreate;
import com.github.th3pl.study_apix.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService  {

    @Autowired
    private ProdutoRepository proutoRepository;

    public Produto save(ProdutoRequestCreate dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        return proutoRepository.save(produto);
    }

}
