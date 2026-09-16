import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {

    private final String nome;
    private int idade;
    private final String cpf;
    private String telefone;
    private List<String> enderecos;
    private String profissao;

    public Pessoa(String nome, int idade, String cpf, String telefone, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.enderecos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<String> getEnderecos() {
        return enderecos;
    }

    public String getProfissao() {
        return profissao;
    }

    public void atualizarIdade(int idade) {
        this.idade = idade;
    }

    public void atualizarTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void atualizarProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void adicionarEndereco(String endereco) {
        this.enderecos.add(endereco);
    }

    public void removerEndereco(String endereco) {
        this.enderecos.remove(endereco);
    }
}