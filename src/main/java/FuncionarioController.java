package controller;

import model.Funcionario;
import model.Profissao;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {

    private final List<Funcionario> funcionarios = new ArrayList<>();

    public Funcionario criar(String nome, String cpf, int idade, String telefone, Profissao profissao, double salario) {
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
                throw new IllegalArgumentException("Já existe uma pessoa cadastrada com esse CPF.");
            }
        }
        Funcionario funcionario = new Funcionario(nome, cpf, idade, telefone, profissao, salario);
        funcionarios.add(funcionario);
        return funcionario;
    }

    public List<Funcionario> listarTodos() {
        return funcionarios;
    }

    public Funcionario buscarPorCpf(String cpf) {
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
                return f;
            }
        }
        return null;
    }

    public Funcionario atualizar(String cpf, Integer idade, String telefone, Profissao profissao, Double salario) {
        Funcionario funcionario = buscarPorCpf(cpf);
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não encontrado para o CPF informado.");
        }

        if (idade != null) {
            funcionario.setIdade(idade);
        }
        if (telefone != null) {
            funcionario.setTelefone(telefone);
        }
        if (profissao != null) {
            funcionario.setProfissao(profissao);
        }
        if (salario != null) {
            funcionario.setSalario(salario);
        }
        return funcionario;
    }

    public void deletar(String cpf) {
        Funcionario funcionario = buscarPorCpf(cpf);
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não encontrado para o CPF informado.");
        }
        funcionarios.remove(funcionario);
    }
}