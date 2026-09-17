import java.util.*;

public class Pessoa {
    private String nome; 
    private String cpf;
    private String telefone;
    private String profissao;
    private int idade;
    private Map<Integer, Endereco> enderecos;

    public Pessoa(String nome, String cpf, String telefone, String profissao, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.idade = idade;
        this.enderecos = new HashMap<>();
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
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

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String toString() {
        return "---Pessoa---\nnome: " + this.nome + "\ncpf: " + this.cpf + "\nidade: " + this.idade + "\ntelefone: " 
        + this.telefone + "\nprofissão: " + this.profissao + "\n------------";
    }

    private Endereco checkEndereco(int numero) {
        return enderecos.get(numero);
    }

    public String cadastraEndereco(String cidade, String cep, String rua, String bairro, int numero) {
        String result = "";
        if (checkEndereco(numero) == null) {
            enderecos.put(numero, new Endereco(cidade, cep, rua, bairro, numero));
            result = "Endereço cadastrado!";
        } else {
            result = "Endereço já existente!";
        }
        return result;
    }

    public String atualizaEndereco(String cidade, String cep, String rua, String bairro, int numero) {
        String result = "";
        if (checkEndereco(numero) != null) {
            enderecos.put(numero, new Endereco(cidade, cep, rua, bairro, numero));
            result = "Endereço atualizado!";
        } else {
            result = "Endereço inexistente!";
        }
        return result;
    }

    public String removeEndereco(int numero) {
        String result = "";
        if (checkEndereco(numero) != null) {
            enderecos.remove(numero);
            result = "Endereço removido!";
        } else {
            result = "Endereço inexistente!";
        }
        return result;
    }

    public String listaEnderecos() {
        String result = "";
        if (enderecos.isEmpty()) {
            result = "Lista vazia!";
        } else {
            for (int n : enderecos.keySet()) {
                result += this.enderecos.get(n).toString() + "\n";
            }
        }
        return result;
    }

    public String mostraEndereco(int numero) {
        String result = "";
        if (checkEndereco(numero) != null) {
            result = enderecos.get(numero).toString();
        } else {
            result = "Endereço inexistente!";
        }
        return result;
    }
}
