import java.util.*;


public class ControllerSystem {
    private Map<String, Pessoa> pessoas;


    public ControllerSystem() {
        this.pessoas = new HashMap<>();
    }


    private Pessoa checkPessoa(String cpf) {
        return pessoas.get(cpf);
    }


    public String cadastraPessoa(String nome, String cpf, String telefone, String profissao, int idade, Cargo cargo) {
        String result = "";
        if (checkPessoa(cpf) == null) {
            pessoas.put(cpf, new Pessoa(nome, cpf, telefone, profissao, idade, cargo));
            result = "Pessoa cadastrada!";
        } else {
            result = "Pessoa já existente!";
        }
        return result;
    }


    public String atualizaIdade(String cpf, int idade) {
        String result = "";
        if (checkPessoa(cpf) != null) {
            pessoas.get(cpf).setIdade(idade);
            result = "Idade atualizada!";
        } else {
            result = "Pessoa inexistente!";
        }
        return result;
    }


    public String atualizaProfissao(String cpf, String profissao) {
        String result = "";
        if (checkPessoa(cpf) != null) {
            pessoas.get(cpf).setProfissao(profissao);
            result = "Profissão atualizada!";
        } else {
            result = "Pessoa inexistente!";
        }
        return result;
    }


    public String atualizaTelefone(String cpf, String telefone) {
        String result = "";
        if (checkPessoa(cpf) != null) {
            pessoas.get(cpf).setTelefone(telefone);
            result = "Telefone atualizado!";
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


    public String cadastraEndereco(String cpf, String cidade, String cep, String rua, String bairro, int numero) {
        String result = "";
        if (checkPessoa(cpf) != null) {
            result = pessoas.get(cpf).cadastraEndereco(cidade, cep, rua, bairro, numero);
        } else {
            result = "Pessoa não cadastrada!";
        }
        return result;
    }


    public String atualizaEndereco(String cpf, String cidade, String cep, String rua, String bairro, int numero) {
        String result = "";
        if (checkPessoa(cpf) != null) {
            result = pessoas.get(cpf).atualizaEndereco(cidade, cep, rua, bairro, numero);
        } else {
            result = "Pessoa não atualizada!";
        }
        return result;
    }


    public String removeEndereco(String cpf, String cep, int numero) {
        String result = "";
        if (checkPessoa(cpf) != null) {
            result = pessoas.get(cpf).removeEndereco(cep, numero);
        } else {
            result = "Pessoa inexistente!";
        }
        return result;
    }


    public String listaEnderecos(String cpf) {
        String result = "";
        if (checkPessoa(cpf) != null) {
            result = pessoas.get(cpf).listaEnderecos();
        } else {
            result = "Pessoa inexistente!";
        }
        return result;
    }


    public String mostraEndereco(String cpf, String cep, int numero) {
        String result = "";
        if (checkPessoa(cpf) != null) {
            result = pessoas.get(cpf).mostraEndereco(cep, numero);
        } else {
            result = "Pessoa inexistente!";
        }
        return result;
    }
}

