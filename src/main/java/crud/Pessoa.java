package crud;

import java.util.List;
import java.util.ArrayList;

public class Pessoa {

    private final String nome;
    private Cpf cpf;

    private int idade;
    private String profissao;
    private List<Endereco> endereco = new ArrayList<>();
    private List<Telefone> telefones = new ArrayList<>();
    private Papel papel;

    

    public Pessoa(String nome, String cpf, int idade, String profissao, List<Endereco> endereco, List<Telefone> telefones,
            Papel papel) {
        this.nome = nome;
        this.cpf = new Cpf(cpf);
        this.idade = idade;
        this.profissao = profissao;
        this.papel = papel;
        this.endereco  = new ArrayList<>(endereco);
        this.telefones = new ArrayList<>(telefones);
    }

    public String getNome() {
        return nome;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }


}
