import java.util.*;

public class Pessoa{
    private String nome;
    private String profissao;
    private String cpf;
    private int idade;
    private String papel;
    private ArrayList<Endereco> enderecos;

    public Pessoa(String cpf, int idade, String nome, String papel, String profissao) {
        this.cpf = cpf;
        this.idade = idade;
        this.nome = nome;
        this.papel = papel;
        this.profissao = profissao;
        this.enderecos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
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

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public void addEndereco(String rua, String bairro, String cidade, String number) {
        Endereco end1 = new Endereco(bairro, cidade, number, rua);
        enderecos.add(end1);
    }

   @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((profissao == null) ? 0 : profissao.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + idade;
        result = prime * result + ((papel == null) ? 0 : papel.hashCode());
        result = prime * result + ((enderecos == null) ? 0 : enderecos.hashCode());
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
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (papel == null) {
            if (other.papel != null)
                return false;
        } else if (!papel.equals(other.papel))
            return false;
        return true;
    }
    
}