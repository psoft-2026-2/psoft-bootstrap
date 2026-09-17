package psoft.service;

import psoft.model.Papel;
import psoft.model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListaDePessoas {
    private List<Pessoa> pessoas = new ArrayList<>();

    public Pessoa createPessoa(String nome, int idade, String cpf, String telefone,
                                List<String> endereco, String profissao, Papel papel) {
        Pessoa pessoa = new Pessoa(nome, idade, cpf, telefone, endereco, profissao, papel);
        pessoas.add(pessoa);
        return pessoa;
    }

    public boolean deletePessoa(String cpf) {
        return pessoas.removeIf(p -> p.getCpf().equals(cpf));
    }

    
    public List<Pessoa> getPessoas() {
        return pessoas;
    }
}