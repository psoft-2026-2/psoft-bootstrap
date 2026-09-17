package psoft.model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private final String nome;
    private int idade;
    private final String cpf;
    private String telefone;
    private List<String> endereco;
    private String profissao;
    private Papel papel;

    public Pessoa(String nome, int idade, String cpf, String telefone,
                  List<String> endereco, String profissao, Papel papel) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = new ArrayList<>(endereco);
        this.profissao = profissao;
        this.papel = papel;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getCpf() { return cpf; }
    public String getTelefone() { return telefone; }
    public List<String> getEndereco() { return endereco; }
    public String getProfissao() { return profissao; }
    public Papel getPapel() { return papel; }

    public void setIdade(int idade) { this.idade = idade; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setEndereco(List<String> endereco) { this.endereco = endereco; }
    public void setProfissao(String profissao) { this.profissao = profissao; }
    public void setPapel(Papel papel) { this.papel = papel; }

    public void adicionarEndereco(String novoEndereco) {
        this.endereco.add(novoEndereco);
    }

    @Override
    public String toString() {
        return "Pessoa{nome='" + nome + "', cpf='" + cpf + "', papel=" + papel + "}";
    }
}