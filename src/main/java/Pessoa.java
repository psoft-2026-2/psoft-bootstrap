
import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private final String nome;
    private final String cpf;
    private int idade;
    private String telefone;
    private List<Endereco> enderecos;
    private String profissao;
    private String papel; 

    public Pessoa(String nome, String cpf, int idade, String telefone, List<Endereco> enderecos, String profissao, String papel) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.enderecos = enderecos != null ? enderecos : new ArrayList<>();
        this.profissao = profissao;
        this.papel = papel;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public List<Endereco> getEnderecos() { return enderecos; }

    public String getProfissao() { return profissao; }
    public void setProfissao(String profissao) { this.profissao = profissao; }

    public String getPapel() { return papel; }
    public void setPapel(String papel) { this.papel = papel; }

    public Endereco temEndereco(String rua, int numero) {
        for (Endereco e : this.enderecos) {
            if (e.getNumero() == numero && e.getRua().equalsIgnoreCase(rua)) {
                return e;
            }
        }
        return null;
    }

    public String cadastrarEndereco(String rua, String bairro, int numero, String cidade, String cep) {
        if (temEndereco(rua, numero) != null) {
            return "Erro: Endereço já cadastrado!";
        }
        this.enderecos.add(new Endereco(rua, bairro, numero, cidade, cep));
        return "Endereço cadastrado com sucesso!";
    }

    public String mostrarEnderecos() {
        if (this.enderecos.isEmpty()) {
            return "Nenhum endereço cadastrado.";
        }
        StringBuilder out = new StringBuilder();
        for (Endereco e : this.enderecos) {
            out.append(e.toString()).append("\n");
        }
        return out.toString();
    }

    public String atualizarEndereco(String ruaOriginal, int numeroOriginal, String novaRua, String novoBairro, int novoNumero, String novaCidade, String novoCep) {
        Endereco end = temEndereco(ruaOriginal, numeroOriginal);
        if (end == null) {
            return "Erro: Endereço não encontrado!";
        }
        end.setRua(novaRua);
        end.setBairro(novoBairro);
        end.setNumero(novoNumero);
        end.setCidade(novaCidade);
        end.setCep(novoCep);
        return "Endereço atualizado com sucesso!";
    }

    public String apagarEndereco(String rua, int numero) {
        Endereco end = temEndereco(rua, numero);
        if (end == null) {
            return "Erro: Endereço não existe!";
        }
        this.enderecos.remove(end);
        return "Endereço apagado com sucesso!";
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", telefone=" + telefone 
                + ", profissao=" + profissao + ", papel=" + papel + "]";
    }
}