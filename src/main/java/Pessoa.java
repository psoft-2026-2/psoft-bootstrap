import java.util.List;
import java.util.ArrayList;

public class Pessoa {
    private final String nome;
    private final String cpf;
    private String profissao;
    private int idade;
    private String telefone;
    private List<Endereco> enderecos;

    public Pessoa(String nome, String cpf, String profissao, int idade, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.profissao = profissao;
        this.idade = idade;
        this.telefone = telefone;
        this.enderecos = new ArrayList<Endereco>();
    }

    public Endereco existeEndereco(String cep, int numero) {
        Endereco end = null;
        
        for (Endereco e : enderecos) {
            if (e.getCep().equals(cep) && e.getNumero() == numero) {
                end = e;
            }
        }

        return end;
    }

    public void adicionaEndereco(String rua, String cidade, int numero, String cep, String bairro) {
        if (existeEndereco(cep, numero) == null) {
            this.enderecos.add(new Endereco(rua, cidade, numero, cep, bairro));
        }
    }

    public Endereco getEndereco(String cep, int numero) {
        return existeEndereco(cep, numero);
    }

    public void atualizaEndereco(String cepAntigo, int numeroAntigo, String rua, String cidade, int numero, String cep, String bairro) {
        Endereco e = existeEndereco(cep, numero);

        if (e == null) {
            throw new IllegalArgumentException("Endereco Invalido");
        }

        e.atualizaEndereco(rua, cidade, numero, cep, bairro);
    }

    public void deleteEndereco(String cep, int numero) {
        Endereco e = existeEndereco(cep, numero);

        if (e == null) {
            throw new IllegalArgumentException("Endereco Invalido");
        }

        this.enderecos.remove(e);
    }

    public void atualizaDados(String profissao, int idade, String telefone) {
        this.profissao = profissao;
        this.telefone = telefone;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
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

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", profissao=" + profissao + ", idade=" + idade + ", telefone="
                + telefone + "]";
    }
}