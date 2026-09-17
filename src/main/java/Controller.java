import java.util.HashMap;
import java.util.Map;

public class Controller {
    private Map<String, Pessoa> pessoas;

    public Controller() {
        this.pessoas = new HashMap<>();
    }

    private boolean temPessoa(String cpf) {
        return this.pessoas.containsKey(cpf);
    }

    public String cadastrarPessoa(String nome, String cpf, String profissao, int idade, String telefone, String papelStr) {
        if (temPessoa(cpf)) {
            return "Pessoa já cadastrada no sistema";
        }

        Papel papel = Papel.fromString(papelStr);
        if (papel == null) {
            return "Papel inválido. Deve ser CLIENTE ou FUNCIONARIO";
        }

        Pessoa novaPessoa = new Pessoa(nome, cpf, profissao, idade, telefone, papel);
        this.pessoas.put(cpf, novaPessoa);
        return "Cadastro realizado com sucesso";
    }

    public String apagarPessoa(String cpf) {
        if (!temPessoa(cpf)) {
            return "Pessoa não cadastrada no sistema";
        }

        this.pessoas.remove(cpf);
        return "Remoção realizada com sucesso";
    }

    public String mostrarPessoa(String cpf) {
        if (!temPessoa(cpf)) {
            return "Pessoa não encontrada";
        }

        return this.pessoas.get(cpf).toString();
    }

    public String listarPessoas() {
        if (this.pessoas.isEmpty()) {
            return "Não existem pessoas cadastradas";
        }

        StringBuilder out = new StringBuilder();
        for (Pessoa pessoa : this.pessoas.values()) {
            out.append(pessoa.toString()).append("\n");
        }
        return out.toString().trim();
    }

    public String atualizarIdade(String cpf, int novaIdade) {
        if (!temPessoa(cpf)) {
            return "Pessoa não encontrada";
        }

        this.pessoas.get(cpf).setIdade(novaIdade);
        return "Idade atualizada com sucesso";
    }

    public String atualizarProfissao(String cpf, String prof) {
        if (!temPessoa(cpf)) {
            return "Pessoa não encontrada";
        }

        this.pessoas.get(cpf).setProfissao(prof);
        return "Profissão atualizada com sucesso";
    }

    public String atualizarTelefone(String cpf, String telefone) {
        if (!temPessoa(cpf)) {
            return "Pessoa não encontrada";
        }

        this.pessoas.get(cpf).setTelefone(telefone);
        return "Telefone atualizado com sucesso";
    }

    public String atualizarPapel(String cpf, String novoPapelStr) {
        if (!temPessoa(cpf)) {
            return "Pessoa não encontrada";
        }

        Papel novoPapel = Papel.fromString(novoPapelStr);
        if (novoPapel == null) {
            return "Papel inválido. Deve ser CLIENTE ou FUNCIONARIO";
        }

        this.pessoas.get(cpf).setPapel(novoPapel);
        return "Papel atualizado com sucesso";
    }

    public String cadastrarEndereco(String cpf, String rua, String bairro, String cidade, String cep, int numero) {
        if (!temPessoa(cpf)) {
            return "Pessoa não encontrada";
        }

        int idEndereco = this.pessoas.get(cpf).cadastrarEndereco(rua, bairro, cidade, cep, numero);
        return "Endereço cadastrado com ID: " + idEndereco;
    }

    public String removerEndereco(String cpf, int idEndereco) {
        if (!temPessoa(cpf)) {
            return "Pessoa não encontrada";
        }

        boolean removeu = this.pessoas.get(cpf).apagarEndereco(idEndereco);
        if (removeu) {
            return "Endereço removido com sucesso";
        }
        return "Endereço não encontrado";
    }

    public String atualizarEndereco(String cpf, int idEndereco, String novaRua, String bairro, String cidade, String cep, int numero) {
        if (!temPessoa(cpf)) {
            return "Pessoa não encontrada";
        }

        boolean atualizou = this.pessoas.get(cpf).atualizarEndereco(idEndereco, novaRua, bairro, cidade, cep, numero);
        if (atualizou) {
            return "Endereço atualizado com sucesso";
        }
        return "Endereço não encontrado";
    }

    public String mostrarEndereco(String cpf, int idEndereco) {
        if (!temPessoa(cpf)) {
            return "Pessoa não encontrada";
        }

        String endereco = this.pessoas.get(cpf).mostrarEndereco(idEndereco);
        if (endereco != null) {
            return endereco;
        }
        return "Endereço não encontrado";
    }

    public String listarEnderecos(String cpf) {
        if (!temPessoa(cpf)) {
            return "Pessoa não encontrada";
        }

        return this.pessoas.get(cpf).listarEnderecos();
    }
}