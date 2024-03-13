package org.example.repositories;

import org.example.entities.Produto;

import java.util.Comparator;
import java.util.List;

public class ProdutoRepository extends _BaseRepositoryImpl<Produto>{
    public List<Produto> BuscarProdutosPorPreco(double minPreco, double maxPreco){
        return entities.stream().filter(item -> item.getPreco() >= minPreco && item.getPreco() <= maxPreco)
                .sorted(Comparator.comparing(Produto::getPreco))
                .toList();
    }

}
