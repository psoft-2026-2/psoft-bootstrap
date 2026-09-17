import java.util.ArrayList;
import java.util.List;

public class CRUD {

    private final List<Pessoa> pessoas;

    public CRUD() {
        this.pessoas = new ArrayList<>();
    }

    public boolean criarPessoa(Pessoa pessoa) {
        if (buscarPessoa(pessoa.getCpf()) != null) {
            return false;
        }

        pessoas.add(pessoa);
        return true;
    }

    public Pessoa buscarPessoa(String cpf) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }

        return null;
    }

    public List<Pessoa> listarPessoas() {
        return new ArrayList<>(pessoas);
    }

    public boolean atualizarIdade(String cpf, int novaIdade) {
        Pessoa pessoa = buscarPessoa(cpf);

        if (pessoa == null) {
            return false;
        }

        pessoa.setIdade(novaIdade);
        return true;
    }

    public boolean atualizarTelefone(String cpf, String novoTelefone) {
        Pessoa pessoa = buscarPessoa(cpf);

        if (pessoa == null) {
            return false;
        }

        pessoa.setTelefone(novoTelefone);
        return true;
    }

    public boolean atualizarProfissao(String cpf, String novaProfissao) {
        Pessoa pessoa = buscarPessoa(cpf);

        if (pessoa == null) {
            return false;
        }

        pessoa.setProfissao(novaProfissao);
        return true;
    }

    public boolean adicionarEndereco(String cpf, Endereco endereco) {
        Pessoa pessoa = buscarPessoa(cpf);

        if (pessoa == null) {
            return false;
        }

        pessoa.adicionarEndereco(endereco);
        return true;
    }

    public boolean removerEndereco(String cpf, Endereco endereco) {
        Pessoa pessoa = buscarPessoa(cpf);

        if (pessoa == null) {
            return false;
        }

        pessoa.removerEndereco(endereco);
        return true;
    }

    public boolean removerPessoa(String cpf) {
        Pessoa pessoa = buscarPessoa(cpf);

        if (pessoa == null) {
            return false;
        }

        pessoas.remove(pessoa);
        return true;
    }
}