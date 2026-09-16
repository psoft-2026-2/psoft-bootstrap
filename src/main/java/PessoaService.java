import java.util.ArrayList;
import java.util.List;

public class PessoaService {

    private List<Pessoa> pessoas = new ArrayList<>();

    public void criarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoas;
    }

    public Pessoa buscarPorCpf(String cpf) {
        for (Pessoa p : pessoas) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    public boolean atualizarPessoa(String cpf, Integer novaIdade, String novoTelefone,
                                    String novaProfissao, String novoTipo) {
        Pessoa p = buscarPorCpf(cpf);
        if (p == null) {
            return false;
        }

        if (novaIdade != null) {
            p.setIdade(novaIdade);
        }
        if (novoTelefone != null) {
            p.setTelefone(novoTelefone);
        }
        if (novaProfissao != null) {
            p.setProfissao(novaProfissao);
        }
        if (novoTipo != null) {
            p.setTipo(novoTipo);
        }

        return true;
    }

    public boolean adicionarEnderecoAPessoa(String cpf, Endereco endereco) {
        Pessoa p = buscarPorCpf(cpf);
        if (p == null) {
            return false;
        }
        p.adicionarEndereco(endereco);
        return true;
    }

    public boolean removerEnderecoDaPessoa(String cpf, Endereco endereco) {
        Pessoa p = buscarPorCpf(cpf);
        if (p == null) {
            return false;
        }
        p.removerEndereco(endereco);
        return true;
    }

    public boolean deletarPessoa(String cpf) {
        return pessoas.removeIf(p -> p.getCpf().equals(cpf));
    }
}