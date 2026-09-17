package model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private final String nome;
    private final String cpf;
    private int idade;
    private String telefone;
    private String profissao;
    private Papel papel;
    private final List<Endereco> enderecos = new ArrayList<>();

    public Pessoa(String nome, String cpf, int idade, String telefone, String profissao, Papel papel) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.profissao = profissao;
        this.papel = papel;
    }

    // nome e cpf nao podem ser atualizados, por isso nao ha setter para eles
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

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void addEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }

    public void removeEndereco(Endereco endereco) {
        enderecos.remove(endereco);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", telefone='" + telefone + '\'' +
                ", profissao='" + profissao + '\'' +
                ", papel=" + papel +
                ", enderecos=" + enderecos +
                '}';
    }
}
