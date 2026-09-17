import java.util.*;

public class Controller {

    private Map<String, Pessoa> pessoas;

    public Controller() {
        this.pessoas = new HashMap<>();
    }

    private boolean temPessoa(String cpf) {
        return this.pessoas.containsKey(cpf);
    }

    // CREATE
    public String cadastrarPessoa(String nome, String cpf, String profissao, int idade, String telefone) {
        String saida;
        if (temPessoa(cpf)) {
            saida = "Pessoa já está cadastrada no sistema";
        } else {
            this.pessoas.put(cpf, new Pessoa(nome, cpf, profissao, idade, telefone));
            saida = "Cadastro realizado com sucesso";
        }
        return saida;
    }

    // READ
    public String mostrarPessoa(String cpf) {
        String saida;
        if (!temPessoa(cpf)) {
            saida = "Pessoa não encontrada";
        } else {
            saida = this.pessoas.get(cpf).toString();
        }
        return saida;
    }

    public String listarPessoas() {
        String saida;
        if (this.pessoas.isEmpty()) {
            saida = "Não existem pessoas cadastradas";
        } else {
            StringBuilder out = new StringBuilder();
            for (Pessoa p : this.pessoas.values()) {
                out.append(p.toString()).append("\n");
            }
            saida = out.toString().trim();
        }
        return saida;
    }

    // UPDATE
    public String atualizarIdade(String cpf, int novaIdade) {
        String saida;
        if (!temPessoa(cpf)) {
            saida = "Pessoa não encontrada";
        } else {
            this.pessoas.get(cpf).setIdade(novaIdade);
            saida = "Idade atualizada com sucesso";
        }
        return saida;
    }

    public String atualizarProfissao(String cpf, String prof) {
        String saida;
        if (!temPessoa(cpf)) {
            saida = "Pessoa não encontrada";
        } else {
            this.pessoas.get(cpf).setProfissao(prof);
            saida = "Profissão atualizada com sucesso";
        }
        return saida;
    }

    public String atualizarTelefone(String cpf, String telefone) {
        String saida;
        if (!temPessoa(cpf)) {
            saida = "Pessoa não encontrada";
        } else {
            this.pessoas.get(cpf).setTelefone(telefone);
            saida = "Telefone atualizado com sucesso";
        }
        return saida;
    }

    // DELETE
    public String apagarPessoa(String cpf) {
        String saida;
        if (!temPessoa(cpf)) {
            saida = "Pessoa não está cadastrada no sistema";
        } else {
            this.pessoas.remove(cpf);
            saida = "Remoção realizada com sucesso";
        }
        return saida;
    }

    // OPERAÇÕES DE ENDEREÇO (Delegação para Pessoa)
    public String cadastrarEndereco(String cpf, String rua, String bairro, int numero, String cep, String cidade) {
        String saida;
        if (!temPessoa(cpf)) {
            saida = "Pessoa não encontrada";
        } else {
            saida = this.pessoas.get(cpf).cadastrarEndereco(rua, bairro, numero, cep, cidade);
        }
        return saida;
    }

    public String removeEndereco(String cpf, int idEndereco) {
        String saida;
        if (!temPessoa(cpf)) {
            saida = "Pessoa não encontrada";
        } else {
            saida = this.pessoas.get(cpf).apagarEndereco(idEndereco);
        }
        return saida;
    }

    public String atualizarEndereco(String cpf, int idEndereco, String novaRua, String novoBairro, int novoNumero, String novoCep, String novaCidade) {
        String saida;
        if (!temPessoa(cpf)) {
            saida = "Pessoa não encontrada";
        } else {
            saida = this.pessoas.get(cpf).atualizarEndereco(idEndereco, novaRua, novoBairro, novoNumero, novoCep, novaCidade);
        }
        return saida;
    }

    public String mostrarEndereco(String cpf, int idEndereco) {
        String saida;
        if (!temPessoa(cpf)) {
            saida = "Pessoa não encontrada";
        } else {
            saida = this.pessoas.get(cpf).mostrarEndereco(idEndereco);
        }
        return saida;
    }

    public String listarEnderecos(String cpf) {
        String saida;
        if (!temPessoa(cpf)) {
            saida = "Pessoa não encontrada";
        } else {
            saida = this.pessoas.get(cpf).listarEnderecos();
        }
        return saida;
    }
}