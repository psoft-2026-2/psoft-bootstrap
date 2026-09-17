import java.util.*;

public class Pessoa {

    private final String nome;
    private final String cpf;
    private String profissao;
    private int idade;
    private String telefone; 
    private Map<Integer, Endereco> enderecos; 

    public Pessoa(String nome, String cpf, String profissao, int idade, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.profissao = profissao;
        this.idade = idade;
        this.telefone = telefone;
        this.enderecos = new HashMap<>();
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

    public Endereco temEndereco(int idEndereco) {
        return this.enderecos.get(idEndereco);
    }

    public String cadastrarEndereco(String rua, String bairro, int numero, String cep, String cidade) {
        Endereco novoEndereco = new Endereco(rua, bairro, numero, cep, cidade);
        this.enderecos.put(novoEndereco.getId(), novoEndereco);
        return "Cadastro de endereço realizado com sucesso. ID: " + novoEndereco.getId();
    }

    public String apagarEndereco(int idEndereco) {
        String saida = "Endereço não existe";
        if (temEndereco(idEndereco) != null){
            this.enderecos.remove(idEndereco);
            saida = "Endereço Removido";
        }
        return saida;
    }

    public String mostrarEndereco(int idEndereco) {
        String saida = "Endereço não encontrado";
        Endereco endereco = temEndereco(idEndereco);
        if(endereco != null){
            saida = endereco.toString();
        }
        return saida;
    }

    public String listarEnderecos() {
        if (this.enderecos.isEmpty()) {
            return "Não existem endereços cadastrados";
        }
        StringBuilder out = new StringBuilder();
        for (Endereco e : this.enderecos.values()) {
            out.append(e.toString()).append("\n");
        }
        return out.toString();
    }

    public String atualizarEndereco(int idEndereco, String novaRua, String novoBairro, int novoNumero, String novoCep, String novaCidade) {
        Endereco end = temEndereco(idEndereco);
        if (end == null) {
            return "Endereço não existe"; 
        }  
        end.setRua(novaRua);
        end.setBairro(novoBairro);
        end.setNumero(novoNumero);
        end.setCep(novoCep);
        end.setCidade(novaCidade);
        return "Endereço atualizado com sucesso";
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", profissao=" + profissao + 
               ", idade=" + idade + ", telefone=" + telefone + ", enderecos=" + this.enderecos.values() + "]";
    }
}