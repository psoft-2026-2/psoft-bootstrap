// "O sistema a ser desenvolvido consiste em um CRUD (create, read, update and delete) de Pessoa,
// com base em informações de nome, idade, cpf, telefone, endereço e profissão.
// Cada pessoa criada no sistema pode ter mais de um endereço cadastrado, mas apenas uma profissão.
// Apenas o nome e o CPF de uma pessoa não podem ser atualizados. Além do mais,
// uma pessoa pode assumir um papel diferente por vez: cliente ou funcionário".
import java.util.List;

public abstract class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private String telefone;
    private List<Endereco> enderecos;
    private String profissao;

    public Pessoa(String nome, int idade, String cpf, String telefone, List<Endereco> enderecos, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.enderecos = enderecos;
        this.profissao = profissao;
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public String getProfissao() {
        return profissao;
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

    public void addEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void removeEndereco(Endereco endereco) {
        this.enderecos.remove(endereco);
    }

    public abstract String toString();

}
