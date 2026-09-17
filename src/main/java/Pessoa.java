import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {

    private final String nome;
    private int idade;
    private final String cpf;
    private String telefone;
    private List<Endereco> enderecos;
    private Profissao profissao;

    public Pessoa(String nome, int idade, String cpf, String telefone, Endereco endereco, Profissao profissao){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.enderecos = new ArrayList<>();
        this.enderecos.add(endereco);
        this.profissao = profissao;
    }

    public String getNome(){
        return this.nome;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setIdade(int novaIdade){
        this.idade = novaIdade;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void setTelefone(String novoTel){
        this.telefone = novoTel;
    }

    public List<Endereco> getEnderecos(){
        return this.enderecos;
    }

    public void adicionarEndereco(Endereco endereco){
        enderecos.add(endereco);
    }

    public Profissao getProfissao(){
        return this.profissao;
    }

    public void setProfissao(Profissao novaProfissao){
        this.profissao = novaProfissao;
    }

}