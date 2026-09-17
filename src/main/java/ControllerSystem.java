import java.util.*;

public class ControllerSystem {
    private Map<String, Pessoa> pessoas;

    public ControllerSystem() {
        this.pessoas = new HashMap<>();
    }

    private Pessoa checkPessoa(String cpf) {
        return pessoas.get(cpf);
    }

    public String cadastraPessoa(String nome, String cpf, String telefone, String profissao, int idade) {
        String result = "";
        if (checkPessoa(cpf) == null) {
            pessoas.put(cpf, new Pessoa(nome, cpf, telefone, profissao, idade));
            result = "Pessoa cadastrada!";
        } else {
            result = "Pessoa já existente!";
        }
        return result;
    }

    public String atualizaPessoa(String nome, String cpf, String telefone, String profissao, int idade) {
        String result = "";
        if (checkPessoa(cpf) != null) {
            pessoas.put(cpf, new Pessoa(nome, cpf, telefone, profissao, idade));
            result = "Pessoa atualizada!";
        } else {
            result = "Pessoa inexistente!";
        }
        return result;
    }

    public String removePessoa(String cpf) {
        String result = "";
        if (checkPessoa(cpf) != null) {
            pessoas.remove(cpf);
            result = "Pessoa removida!";
        } else {
            result = "Pessoa inexistente!";
        }
        return result;
    }

    public String listaPessoas() {
        String result = "";
        if (pessoas.isEmpty()) {
            result = "Lista vazia!";
        } else {
            for (String n : pessoas.keySet()) {
                result += pessoas.get(n).toString() + "\n";
            }
        }
        return result;
    }

    public String mostraPessoa(String cpf) {
        String result = "";
        if (checkPessoa(cpf) != null) {
            result = pessoas.get(cpf).toString();
        } else {
            result = "Pessoa inexistente!";
        }
        return result;
    }

    public String cadastraEndereco(String cidade, String cep, String rua, String bairro, int numero) {
        String result = "";
        
        return result;
    }

    public String atualizaEndereco(String cidade, String cep, String rua, String bairro, int numero) {
        String result = "";
        
        return result;
    }

    public String removeEndereco(int numero) {
        String result = "";
        
        return result;
    }

    public String listaEnderecos() {
        String result = "";
        
        return result;
    }

    public String mostraEndereco(int numero) {
        String result = "";
        
        return result;
    }
}
