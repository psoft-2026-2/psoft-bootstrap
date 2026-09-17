import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private String cpf;
    private String telefone;
    private String nome;
    private Profissao profissao;
    private List<Endereco> enderecos;

    public Pessoa(String cpf, String telefone, String nome, Profissao profissao) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
        this.profissao = profissao;
        this.enderecos = new ArrayList<>();
    }

    public void adicionarEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }

    public void removerEndereco(Endereco endereco) {
        enderecos.remove(endereco);
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }
}