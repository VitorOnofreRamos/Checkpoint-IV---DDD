package org.example.repositories;

import org.example.entities.Cliente;

import java.util.Comparator;
import java.util.List;

public class ClienteRepository extends _BaseRepositoryImpl<Cliente>{
    public List<Cliente> BuscarClientesPorNome(String nome){
        return entities.stream().filter(item -> item.getNome().contains(nome))
                .sorted(Comparator.comparing(Cliente::getNome))
                .toList();
    }
}
