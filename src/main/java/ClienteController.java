package controller;

import model.Cliente;
import model.Profissao;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    private final List<Cliente> clientes = new ArrayList<>();

    public Cliente criar(String nome, String cpf, int idade, String telefone, Profissao profissao) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                throw new IllegalArgumentException("Já existe uma pessoa cadastrada com esse CPF.");
            }
        }
        Cliente cliente = new Cliente(nome, cpf, idade, telefone, profissao);
        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> listarTodos() {
        return clientes;
    }

    public Cliente buscarPorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public Cliente atualizar(String cpf, Integer idade, String telefone, Profissao profissao) {
        Cliente cliente = buscarPorCpf(cpf);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado para o CPF informado.");
        }

        if (idade != null) {
            cliente.setIdade(idade);
        }
        if (telefone != null) {
            cliente.setTelefone(telefone);
        }
        if (profissao != null) {
            cliente.setProfissao(profissao);
        }
        return cliente;
    }

    public void deletar(String cpf) {
        Cliente cliente = buscarPorCpf(cpf);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado para o CPF informado.");
        }
        clientes.remove(cliente);
    }
}