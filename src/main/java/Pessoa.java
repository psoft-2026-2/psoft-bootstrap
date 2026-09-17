import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {

    protected String nome;
    protected int idade;
    protected String cpf;
    protected String telefone;
    protected String profissao;
    protected List<String> enderecos;

    public Pessoa(String nome, int idade, String cpf,
                  String telefone, String profissao) {

        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.enderecos = new ArrayList<>();
    }

    public void addEndereco(String endereco) {
        enderecos.add(endereco);
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

    public String getProfissao() {
        return profissao;
    }

    public String getTelefone() {
        return telefone;
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
}