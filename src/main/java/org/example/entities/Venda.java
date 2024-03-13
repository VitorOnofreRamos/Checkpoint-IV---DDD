package org.example.entities;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Venda extends _BaseEntity{
    private transient Cliente cliente;
    private Map<Produto, Integer> itensVenda = new HashMap<>();
    private LocalDateTime data;
    private double valorTotal;

    public Venda(){}

    public Venda(int id, Cliente cliente, Map<Produto, Integer> itensVenda, LocalDateTime data, double valorTotal) {
        super(id);
        this.cliente = cliente;
        this.itensVenda = itensVenda;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Map<Produto, Integer> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(Map<Produto, Integer> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double calcularTotal(){
        valorTotal = 0;
        for (Map.Entry<Produto, Integer> entry : itensVenda.entrySet()){
            valorTotal += entry.getKey().getPreco() * entry.getValue();
        }
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "cliente=" + cliente +
                ", itensVenda=" + itensVenda +
                ", data=" + data +
                ", valorTotal=" + valorTotal +
                ", id=" + id +
                '}';
    }
}
