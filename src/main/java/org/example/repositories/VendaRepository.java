package org.example.repositories;

import org.example.entities.Produto;
import org.example.entities.Venda;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class VendaRepository extends _BaseRepositoryImpl<Venda>{
    public List<Venda> BuscarVendasPorData(LocalDateTime data){
        return entities.stream().filter(item -> item.getData().equals(data))
                .sorted(Comparator.comparing(Venda::getData))
                .toList();
    }
}
