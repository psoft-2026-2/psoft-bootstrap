package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Pessoa;

public class PessoaRepository {

    private final List<Pessoa> pessoas = new ArrayList<>();

    public Pessoa create(Pessoa pessoa) {
        pessoas.add(pessoa);
        return pessoa;
    }

    public List<Pessoa> readAll() {
        return pessoas;
    }

    public Optional<Pessoa> readByCpf(String cpf) {
        return pessoas.stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst();
    }

    public boolean delete(String cpf) {
        return pessoas.removeIf(p -> p.getCpf().equals(cpf));
    }
}
