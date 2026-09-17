import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private final String nome;
    private final String cpf;

    private int idade;
    private String telefone;
    private List<Endereco> enderecos;
    private Profissao profissao;
    private Papel papel;

    public Pessoa(
        String nome,
        int idade,
        String cpf,
        String telefone,
        Profissao profissao,
        Papel papel
    ) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.papel = papel;
        this.enderecos = new ArrayList<>();
    }

    // Nome e CPF possuem apenas getters.
    // Não existem setters, portanto não podem ser alterados.

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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public void adicionarEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }

    public void removerEndereco(Endereco endereco) {
        enderecos.remove(endereco);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", enderecos=" + enderecos +
                ", profissao=" + profissao +
                ", papel=" + papel +
                '}';
    }
}