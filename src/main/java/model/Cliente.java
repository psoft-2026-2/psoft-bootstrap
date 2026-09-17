package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

    private final List<String> cartoes;
    private String informacoes;

    public Cliente(String nome, String cpf, int idade, String telefone, String profissao) {
        super(nome, cpf, idade, telefone, profissao);
        this.cartoes = new ArrayList<>();
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setObservacoes(String informacoes) {
       this.informacoes = informacoes;
    }

     public List<String> getCartoes() {
        return cartoes;
    }

    public void adicionarCartao(String cartao) {
        this.cartoes.add(cartao);
    }

    public boolean removerCartao(String cartao) {
        return this.cartoes.remove(cartao);
    }

    @Override
    public String getPapel() {
        return "Cliente";
    }
}