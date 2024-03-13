package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends _BaseEntity{
    private String nome;
    private String email;
    private String endereco;
    private List<Venda> historicoDeCompras = new ArrayList<>();

    public Cliente(){}

    public Cliente(int id, String nome, String email, String endereco, List<Venda> historicoDeCompras) {
        super(id);
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.historicoDeCompras = historicoDeCompras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Venda> getHistoricoDeCompras() {
        return historicoDeCompras;
    }

    public void setHistoricoDeCompras(List<Venda> historicoDeCompras) {
        this.historicoDeCompras = historicoDeCompras;
    }

    public void adcionarCompra (Venda venda){
        if(venda != null){
            this.historicoDeCompras.add(venda);
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                //", historicoDeCompras=" + historicoDeCompras +
                ", id=" + id +
                '}';
    }
}
