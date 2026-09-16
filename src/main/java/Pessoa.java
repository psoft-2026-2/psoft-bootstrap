import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    private String cpf;
    private String nome;
    private int idade;
    private String telefone;
    private List<Endereco> enderecos;

    public Pessoa(String cpf, String nome, int idade, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.enderecos = new ArrayList<Endereco>();
    }

    public void atualizarIdade(int idade) { this.idade = idade; }

    public void atualizarTelefone(String telefone) { this.telefone = telefone; }

    public boolean atualizarEndereco(int id, String rua, String num, String cep, String cidade, String estado) {
        Endereco endereco = null;
        for (Endereco end : enderecos)
            if (end.getId() == id) endereco = end;

        if (endereco == null)  return false;

        endereco.atualizarEndereco(rua, num, cep, cidade, estado);
        return true;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }
}
