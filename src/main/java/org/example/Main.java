package org.example;

import org.example.entities.Cliente;
import org.example.entities.Produto;
import org.example.entities.Venda;
import org.example.repositories.ClienteRepository;
import org.example.repositories.ProdutoRepository;
import org.example.repositories.VendaRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ClienteRepository clienteRepository = new ClienteRepository();
        VendaRepository vendaRepository = new VendaRepository();
        ProdutoRepository produtoRepository = new ProdutoRepository();

        var novoCliente1 = new Cliente(1, "João", "Joa0@gmail.com", "Rua Machado Pinheiros 154", new ArrayList<>());
        var novoCliente2 = new Cliente(2, "Marcos", "ma4rcs@gmail.com", "Rua Oliveira Silva 123", new ArrayList<>());

        clienteRepository.Create(novoCliente1);
        clienteRepository.Create(novoCliente2);

        var novoProduto1 = new Produto(1, "Monitor Dell", "Aproveite a visualização desta tela de 21,5 com borda fina, tecnologia VA, alta taxa de contraste e um suporte fixo compacto.", 678.0, 3);
        var novoProduto2 = new Produto(2, "C3Tech Caixa de som", "Sistema de audio 2.0 P2 Com Blindagem Eletromagnética alimentacao via porta USB", 31.71, 8);
        var novoProduto3 = new Produto(3, "Mouse Multilaser", "Mouse Multilaser Emborrachado Preto Com Fio Usb - MO222", 29.27, 5);

        produtoRepository.Create(novoProduto1);
        produtoRepository.Create(novoProduto2);
        produtoRepository.Create(novoProduto3);

        //Realizar Venda

        Map<Produto, Integer> produtosMapeados = new HashMap<>();
        produtosMapeados.put(produtoRepository.FindById(1), 2);
        produtosMapeados.put(produtoRepository.FindById(3), 4);

        LocalDateTime dataVenda = LocalDateTime.now();

        double valorTotal = 0;

        var novaVenda = new Venda(1, clienteRepository.FindById(2), produtosMapeados, dataVenda, valorTotal);

        novaVenda.calcularTotal();
        //804,84

        vendaRepository.Create(novaVenda);

        clienteRepository.FindById(1).adcionarCompra(vendaRepository.FindById(1));

        try(var file = new FileWriter("vendas.json")){
            var writer = new BufferedWriter(file);
            writer.write(vendaRepository.FindById(1).toJson());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(var file = new FileWriter("produtos.json")){
            var writer = new BufferedWriter(file);
            writer.write(produtoRepository.FindById(3).toJson());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(var file = new FileWriter("clientes.json")){
            var writer = new BufferedWriter(file);
            writer.write(clienteRepository.FindById(2).toJson());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}