import java.util.ArrayList;
import java.util.List;

public class Pessoas {
    private final String nome;
    private Integer idade;
    private final String cpf;
    private String telefone;
    private List<Endereco> enderecos;
    private String profissao;

    public Pessoas(String nome, Integer idade, String cpf, String telefone, String profissao) {
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

    public Integer getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getProfissao() {
        return profissao;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void adicionarEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }

}