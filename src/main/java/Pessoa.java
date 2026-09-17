import java.util.*;

public abstract class Pessoa {
    private String nome;
    private int idade;
    private final Cpf cpf;
    private List<Endereco> enderecos;
    private Profissao profissao;
    private String telefone;


    public Pessoa(String nome, int idade, Cpf cpf, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.enderecos = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int novaIdade) {
        this.idade = novaIdade;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String novoTelefone) {
        this.telefone = novoTelefone;
    }

    public Cpf getCpf() {
        return this.cpf;
    }

    public List<Endereco> getEnderecos() {
        return this.enderecos;
    }

    public Profissao getProfissao() {
        return this.profissao;
    }
    public void setProfissao(Profissao novaProfissao) {
        this.profissao = novaProfissao;
    }

    public void adicionaEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void removeEndereco(Endereco endereco) {
        this.enderecos.remove(endereco);
    }
}