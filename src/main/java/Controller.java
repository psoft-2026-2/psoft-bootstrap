import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Controller {
    private Map<String, Pessoa> pessoas;

    public Controller() {
        this.pessoas = new HashMap<>();
    }

    private boolean temPessoa(String cpf) {
        return this.pessoas.containsKey(cpf);
    }

    public String cadastrarPessoa(String nome, String cpf, int idade, String telefone, String profissao, String papel) {
        if (temPessoa(cpf)) {
            return "pessoa já está cadastrada no sistema";
        }
        this.pessoas.put(cpf, new Pessoa(nome, cpf, idade, telefone, new ArrayList<>(), profissao, papel));
        return "cadastro realizado";
    }

    public String apagarPessoa(String cpf) {
        if (!temPessoa(cpf)) {
            return "Pessoa não está cadastrada no sistema";
        }
        this.pessoas.remove(cpf);
        return "remoção realizada";
    }

    public String mostrarPessoa(String cpf) {
        if (temPessoa(cpf)) {
            return this.pessoas.get(cpf).toString();
        }
        return "pessoa não encontrada";
    }

    public String listarPessoas() {
        if (this.pessoas.isEmpty()) {
            return "não existe pessoas";
        }
        StringBuilder out = new StringBuilder();
        for (Pessoa p : this.pessoas.values()) {
            out.append(p.toString()).append("\n");
        }
        return out.toString();
    }

    public String cadastrarEndereco(String cpf, String rua, String bairro, int numero, String cidade, String cep) {
        if (!temPessoa(cpf)) {
            return "pessoa não encontrada";
        }
        return this.pessoas.get(cpf).cadastrarEndereco(rua, bairro, numero, cidade, cep);
    }

    public String removeEnd(String cpf, String rua, int numero) {
        if (!temPessoa(cpf)) {
            return "pessoa não encontrada";
        }
        return this.pessoas.get(cpf).apagarEndereco(rua, numero);
    }

    public String atualizarIdade(String cpf, int novaIdade) {
        if (!temPessoa(cpf)) {
            return "pessoa não encontrada";
        }
        this.pessoas.get(cpf).setIdade(novaIdade);
        return "atualizado com sucesso";
    }

    public String atualizarProfissao(String cpf, String prof) {
        if (!temPessoa(cpf)) {
            return "pessoa não encontrada";
        }
        this.pessoas.get(cpf).setProfissao(prof);
        return "atualizado com sucesso";
    }

    public String atualizarTelefone(String cpf, String telefone) {
        if (!temPessoa(cpf)) {
            return "pessoa não encontrada";
        }
        this.pessoas.get(cpf).setTelefone(telefone);
        return "atualizado com sucesso";
    }

    public String atualizarPapel(String cpf, String novoPapel) {
        if (!temPessoa(cpf)) {
            return "pessoa não encontrada";
        }
        this.pessoas.get(cpf).setPapel(novoPapel);
        return "papel atualizado com sucesso";
    }

    public String atualizarEndereco(String cpf, String ruaOriginal, int numeroOriginal, String novaRua, String novoBairro, int novoNumero, String novaCidade, String novoCep) {
        if (!temPessoa(cpf)) {
            return "pessoa não encontrada";
        }
        return this.pessoas.get(cpf).atualizarEndereco(ruaOriginal, numeroOriginal, novaRua, novoBairro, novoNumero, novaCidade, novoCep);
    }

    public String listarEnderecos(String cpf) {
        if (!temPessoa(cpf)) {
            return "pessoa não encontrada";
        }
        return this.pessoas.get(cpf).mostrarEnderecos();
    }
}