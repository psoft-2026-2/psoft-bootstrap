import java.util.LinkedList;

public class Pessoa {
    private String nome;
    private int idade;
    private CPF cpfUser;
    private LinkedList<Endereco> enderecos;
    private String profissao;
    private Funcao funcao;

    public Pessoa(String nome, int idade, CPF cpfUser) {
        this.nome = nome;
        this.idade = idade;
        this.cpfUser = cpfUser;
        this.enderecos = new LinkedList<Endereco>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public CPF getCpfUser() {
        return this.cpfUser;
    }

    public LinkedList<Endereco> getEnderecos() {
        return this.enderecos;
    }

    public String getProfissao() {
        return this.profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Funcao getFuncao() {
        return this.funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public void addEndereco(Endereco endereco) {
        if (endereco != null) {
            this.enderecos.add(endereco);
        }
    }
}
