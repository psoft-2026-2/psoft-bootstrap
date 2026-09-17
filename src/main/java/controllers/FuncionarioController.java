package controllers;

import java.util.ArrayList;
import java.util.List;
import pessoa.Funcionario;

public class FuncionarioController {

    private List<Funcionario> funcionarios;

    public FuncionarioController(){
        this.funcionarios = new ArrayList<>();
    }

    public void criarFuncionario(Funcionario funcionario) {
        if (buscarFuncionario(funcionario.getCpf()) == null) {
            funcionarios.add(funcionario);
        }
    }

    public Funcionario buscarFuncionario(String cpf) {
        Funcionario funcionario = null;
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equalsIgnoreCase(cpf)) {
                funcionario = f;
            }
        }
        return funcionario;
    }

    public void atualizarFuncionario(String cpf, int novaIdade, String novoTelefone, String novaProfissao) {
        Funcionario funcionario = buscarFuncionario(cpf);
        if (funcionario != null) {
            funcionario.setIdade(novaIdade);
            funcionario.setTelefone(novoTelefone);
            funcionario.setProfissao(novaProfissao);
        }
    }

    public void deletarFuncionario(String cpf) {
        Funcionario funcionario = buscarFuncionario(cpf);
        if (funcionario != null) {
            funcionarios.remove(funcionario);
        }
    }
}