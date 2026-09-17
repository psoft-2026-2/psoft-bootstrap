import java.util.ArrayList;

public class Pessoa{
    private String nome;
    private Cpf cpf;
    private int idade;
    private Telefone telefone;
    private ArrayList<Endereco> enderecos;
    private String profissao;
    private Papel papel;

    public Pessoa(String nome, Cpf cpf, int idade, Telefone telefone, String profissao, Papel papel) {
        this.nome = nome;
        this.cpf = cpf;
        if (idade >= 1) {
            this.idade = idade;
        } else { 
            throw new IllegalArgumentException("IDADE INVÁLIDA");
        }
        this.telefone = telefone;
        this.enderecos = new ArrayList<Endereco>();
        this.profissao = profissao;
        this.papel = papel;
    }

    public void setIdade(int idade) {
        if (idade >= 1) this.idade = idade;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public boolean addEndereco(Endereco endereco) {
        return enderecos.add(endereco);
    }

    public boolean removeEndereco(Endereco endereco) {
        return enderecos.remove(endereco);
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Cpf getCpf(){
        return this.cpf;
    }

    public void changePapel(){
        this.papel = this.papel == Papel.CLIENTE? Papel.FUNCIONARIO: Papel.CLIENTE;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", telefone=" + telefone + ", enderecos="
                + enderecos + ", profissao=" + profissao + ", papel=" + papel + "]";
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