package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {

    private final String nome;
    private final String cpf;
    private int idade;
    private String telefone;
    private String profissao;
    private final List<String> enderecos;

    protected Pessoa(String nome, String cpf, int idade, String telefone, String profissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.profissao = profissao;
        this.enderecos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getProfissao() {
        return profissao;
    }

    public List<String> getEnderecos() {
        return enderecos;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void adicionarEndereco(String endereco) {
        this.enderecos.add(endereco);
    }

    public boolean removerEndereco(String endereco) {
        return this.enderecos.remove(endereco);
    }

    public abstract String getPapel();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Papel: ").append(getPapel())
          .append(" | Nome: ").append(nome)
          .append(" | CPF: ").append(cpf)
          .append(" | Idade: ").append(idade)
          .append(" | Telefone: ").append(telefone)
          .append(" | Profissão: ").append(profissao)
          .append(" | Endereços: ").append(enderecos.size());
        return sb.toString();
    }
}

