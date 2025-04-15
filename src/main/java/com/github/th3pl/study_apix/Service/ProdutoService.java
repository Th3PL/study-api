package com.github.th3pl.study_apix.Service;

import com.github.th3pl.study_apix.Model.Produto;
import com.github.th3pl.study_apix.dto.ProdutoRequestCreate;
import com.github.th3pl.study_apix.dto.ProdutoRequestUpdate;
import com.github.th3pl.study_apix.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService  {

    @Autowired
    private ProdutoRepository proutoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(ProdutoRequestCreate dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        return proutoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return proutoRepository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return proutoRepository.findById(id);
    }

    public boolean deleteById(Long id) {
       if(proutoRepository.existsById(id)) {
           proutoRepository.deleteById(id);
           return true;
       }
        return false;
    }

    public Optional<Produto> update(Long id, ProdutoRequestUpdate dto) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(dto.getNome());
                    return produtoRepository.save(produto);
                });
    }
}
