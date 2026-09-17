package entities;

import enums.Papel;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private static int proximoId = 1;

    private final int id;
    private final String nome;
    private final String cpf;

    private int idade;
    private String telefone;
    private String profissao;
    private Papel papel;
    private final List<Endereco> enderecos;

    public Pessoa(String nome, String cpf, int idade, String telefone, String profissao, Papel papel) {
        this.id = proximoId++;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.profissao = profissao;
        this.papel = papel;
        this.enderecos = new ArrayList<>();
    }

    public int getId() {
        return id;
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

    public void adicionarEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }

    public void removerEndereco(int enderecoId) {
        for (Endereco e : enderecos) {
            if (e.getId() == enderecoId) {
                enderecos.remove(enderecoId);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public String toString() {
        return String.format(
                "Pessoa{id=%d, nome='%s', cpf='%s', idade=%d, telefone='%s', profissao='%s', papel=%s, enderecos=%d}",
                id, nome, cpf, idade, telefone, profissao, papel, enderecos.size());
    }
}