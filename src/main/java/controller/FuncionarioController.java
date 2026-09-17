package controller;
import java.util.ArrayList;
import java.util.List;

import entities.Funcionario;
public class FuncionarioController {
    
    private List<Funcionario> funcionarios;

    public FuncionarioController() {
        this.funcionarios = new ArrayList<Funcionario>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void criarFuncionario(String nome, String cpf, int idade, String telefone, String endereco, String profissao) {
        Funcionario funcionario = new Funcionario(nome, cpf, idade, telefone, endereco, profissao);
        adicionarFuncionario(funcionario);
    }

    public boolean deletarFuncionario(Funcionario funcionario) {
        return this.funcionarios.remove(funcionario);
    }
    
}
