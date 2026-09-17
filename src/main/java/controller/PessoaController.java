package controller;

import model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaController {

    private final List<Pessoa> pessoas = new ArrayList<>();


    public void criar(Pessoa pessoa) {
        if (buscarPorCpf(pessoa.getCpf()).isPresent()) {
            throw new IllegalArgumentException("Já existe uma pessoa cadastrada com o CPF " + pessoa.getCpf());
        }
        pessoas.add(pessoa);
    }

    public List<Pessoa> listarTodos() {
        return new ArrayList<>(pessoas);
    }

    public Optional<Pessoa> buscarPorCpf(String cpf) {
            return pessoas.stream()
                    .filter(p -> p.getCpf().equals(cpf))
                    .findFirst();
        }

    public boolean atualizar(String cpf, Integer novaIdade, String novoTelefone, String novaProfissao) {
        Optional<Pessoa> pessoaOpt = buscarPorCpf(cpf);
        if (pessoaOpt.isEmpty()) {
            return false;
        }
        Pessoa pessoa = pessoaOpt.get();
        if (novaIdade != null) {
            pessoa.setIdade(novaIdade);
        }
        if (novoTelefone != null) {
            pessoa.setTelefone(novoTelefone);
        }
        if (novaProfissao != null) {
            pessoa.setProfissao(novaProfissao);
        }
        return true;
    }

    public boolean adicionarEndereco(String cpf, String endereco) {
        Optional<Pessoa> pessoaOpt = buscarPorCpf(cpf);
        if (pessoaOpt.isEmpty()) {
            return false;
        }
        pessoaOpt.get().adicionarEndereco(endereco);
        return true;
    }

    public boolean deletar(String cpf) {
        return pessoas.removeIf(p -> p.getCpf().equals(cpf));
    }
}

