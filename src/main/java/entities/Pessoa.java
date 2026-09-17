package entities;
import java.util.ArrayList;
import java.util.List;
public abstract class Pessoa {

    private String nome;
    private String cpf;
    private int idade;
    private String telefone;
    private List<String> enderecos;
    private String profissao;

    protected Pessoa(String nome, String cpf, int idade, String telefone, String endereco, String profissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.enderecos = new ArrayList<>();
        this.enderecos.add(endereco);
        this.profissao = profissao;
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

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<String> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(String endereco) {
        this.enderecos.add(endereco);
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public boolean equals(Pessoa other) {
        return this.cpf.equals(other.getCpf());
    }

   
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", telefone='" + telefone + '\'' +
                ", enderecos=" + enderecos +
                ", profissao='" + profissao + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }
    
}