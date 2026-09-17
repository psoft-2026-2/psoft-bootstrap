package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Pessoa {

    private final String nome;   // imutável após criação
    private final String cpf;    // imutável após criação
    private int idade;
    private String telefone;
    private List<Endereco> enderecos;
    private Profissao profissao;

    protected Pessoa(String nome, String cpf, int idade, String telefone, Profissao profissao) {
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

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void adicionarEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void removerEndereco(Endereco endereco) {
        this.enderecos.remove(endereco);
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }
