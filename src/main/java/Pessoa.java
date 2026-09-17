mport java.util.ArrayList;
import java.util.Objects;
 
public class Pessoa {
 
    private final String nome;
    private int idade;
    private final String cpf;
    private String telefone;
    private ArrayList<String> endereco;
    private String profissao;
 
    public Pessoa(String nome, int idade, String endereco, String cpf, String telefone, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.endereco = new ArrayList<>();
        this.endereco.add(endereco);
    }
 
    public void addEndereco(String endereco) {
        this.endereco.add(endereco);
    }
 
    public void removeEndereco(String endereco) {
        this.endereco.remove(endereco);
    }
 
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
 
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
 
    public void setIdade(int idade) {
        this.idade = idade;
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
 
    public ArrayList<String> getEndereco() {
        return endereco;
    }
 
    public String getProfissao() {
        return profissao;
    }
 
    @Override
    public String toString() {
        return " nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                ", profissao='" + profissao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(cpf, pessoa.cpf);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}