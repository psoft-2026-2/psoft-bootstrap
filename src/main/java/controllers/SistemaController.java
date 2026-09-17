package controllers;

import entities.*;
import enums.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaController {

    private final Map<Integer, Pessoa> pessoas = new HashMap<>();

    public Pessoa criarPessoa(String nome, String cpf, int idade, String telefone, String profissao, Papel papel) {
        Pessoa pessoa = new Pessoa(nome, cpf, idade, telefone, profissao, papel);
        pessoas.put(pessoa.getId(), pessoa);
        return pessoa;
    }

    public Pessoa buscarPorId(int id) {
        Pessoa pessoa = pessoas.get(id);
        if (pessoa == null) {
            throw new IllegalArgumentException("Pessoa não encontrada para o id: " + id);
        }
        return pessoa;
    }

    public List<Pessoa> listarTodas() {
        return new ArrayList<>(pessoas.values());
    }

    public Pessoa atualizarDadosBasicos(int id, int idade, String telefone, String profissao) {
        Pessoa pessoa = buscarPorId(id);
        pessoa.setIdade(idade);
        pessoa.setTelefone(telefone);
        pessoa.setProfissao(profissao);
        return pessoa;
    }

    public Pessoa trocarPapel(int id, Papel novoPapel) {
        Pessoa pessoa = buscarPorId(id);
        pessoa.setPapel(novoPapel);
        return pessoa;
    }

    public Pessoa adicionarEndereco(int id, Endereco endereco) {
        Pessoa pessoa = buscarPorId(id);
        pessoa.adicionarEndereco(endereco);
        return pessoa;
    }

    public Pessoa removerEndereco(int id, int enderecoId) {
        Pessoa pessoa = buscarPorId(id);
        pessoa.removerEndereco(enderecoId);
        return pessoa;
    }

    public void deletarPessoa(int id) {
        if (pessoas.remove(id) == null) {
            throw new IllegalArgumentException("Pessoa não encontrada para o id: " + id);
        }
    }
}