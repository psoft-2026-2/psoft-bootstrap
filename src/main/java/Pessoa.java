import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private String telefone;
    private String profissao;
    private String tipo;

    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa(String nome, int idade, String cpf, String telefone, String profissao, String tipo) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        setTipo(tipo);
    }

    public void adicionarEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void removerEndereco(Endereco endereco) {
        this.enderecos.remove(endereco);
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null ||
                (!tipo.equalsIgnoreCase("cliente") && !tipo.equalsIgnoreCase("funcionario"))) {
            throw new IllegalArgumentException("Tipo deve ser 'cliente' ou 'funcionario'");
        }
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", profissao='" + profissao + '\'' +
                ", tipo='" + tipo + '\'' +
                ", enderecos=" + enderecos +
                '}';
    }
}