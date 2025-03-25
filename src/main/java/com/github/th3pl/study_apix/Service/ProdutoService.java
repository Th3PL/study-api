package com.github.th3pl.study_apix.Service;

import com.github.th3pl.study_apix.Model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    List<Produto> produtos = new ArrayList<>();
    private long id = 1L;


    public Produto save(Produto request) {
        request.setId(id++);
        produtos.add(request);
        return request;
    }


    public Produto find(long id) {
        for (Produto i : produtos){
            if (i.getId() ==  id){
                return i;
            }
        }
        return null;
    }
}
