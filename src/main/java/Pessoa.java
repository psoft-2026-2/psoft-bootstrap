import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private final String nome;
    private final String cpf;
    private int idade;
    private String telefone;
    private String profissao;
    private Papel papel;
    private List<Endereco> enderecos;

    public Pessoa(String nome, String cpf, String profissao, int idade, String telefone, Papel papel) {
        this.nome = nome;
        this.cpf = cpf;
        this.profissao = profissao;
        this.idade = idade;
        this.telefone = telefone;
        
        if (papel != null) {
            this.papel = papel;
        } else {
            this.papel = Papel.CLIENTE;
        }
        
        this.enderecos = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getProfissao() {
        return this.profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Papel getPapel() {
        return this.papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public int cadastrarEndereco(String rua, String bairro, String cidade, String cep, int numero) {
        Endereco novoEndereco = new Endereco(rua, bairro, cidade, cep, numero);
        this.enderecos.add(novoEndereco);
        return this.enderecos.size() - 1;
    }

    public boolean apagarEndereco(int indice) {
        if (indice >= 0 && indice < this.enderecos.size()) {
            this.enderecos.remove(indice);
            return true;
        }
        return false;
    }

    public boolean atualizarEndereco(int indice, String rua, String bairro, String cidade, String cep, int numero) {
        if (indice >= 0 && indice < this.enderecos.size()) {
            Endereco endereco = this.enderecos.get(indice);
            endereco.setRua(rua);
            endereco.setBairro(bairro);
            endereco.setCidade(cidade);
            endereco.setCep(cep);
            endereco.setNumero(numero);
            return true;
        }
        return false;
    }

    public String mostrarEndereco(int indice) {
        if (indice >= 0 && indice < this.enderecos.size()) {
            return this.enderecos.get(indice).toString();
        }
        return null;
    }

    public String listarEnderecos() {
        if (this.enderecos.isEmpty()) {
            return "Nenhum endereço cadastrado";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.enderecos.size(); i++) {
            sb.append("[").append(i).append("] ")
              .append(this.enderecos.get(i).toString())
              .append("\n");
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + this.nome 
                + ", cpf=" + this.cpf 
                + ", idade=" + this.idade 
                + ", telefone=" + this.telefone 
                + ", profissao=" + this.profissao 
                + ", papel=" + this.papel 
                + ", enderecos=" + this.enderecos + "]";
    }
}