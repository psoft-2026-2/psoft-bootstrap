import java.util.List;
import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private String telefone;
    private String profissao;
    private Papel papel;
    private List<String> enderecos;
    
    public Pessoa(String nome, int idade, String cpf, String telefone, String profissao, String papel) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.papel = Papel.valueOf(papel);
        this.enderecos = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getProfissao() {
        return this.profissao;
    }

    public String getPapel() {
        return this.papel.name();
    }

    public List<String> getEnderecos() {
        return this.enderecos;
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

    public void setPapel(String papel) {
        this.papel = Papel.valueOf(papel);
    }

    public void adicionaEndereco(String endereco) {
        this.enderecos.add(endereco);
    }

    public boolean equals(Object o) {
        if (o instanceof Pessoa) {
            return this.cpf.equals(((Pessoa) o).cpf);
        }
        return false;
    }

    public int hashCode() {
        return cpf.hashCode();
    }

    public String toString() {
        return this.nome + ", " + idade + " anos. Contato: " + telefone + ", profissão: " + profissao + ", papel: " + papel.name()
            + ", enderecos: " + String.join(", ", enderecos);
    }
}
