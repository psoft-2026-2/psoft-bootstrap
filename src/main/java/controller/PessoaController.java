package controller;

import java.util.ArrayList;
import java.util.List;

import modelo.Pessoa;

public class PessoaController {
    private List<Pessoa> pessoas = new ArrayList<>();

    public void cadastrar(Pessoa pessoa){
        this.pessoas.add(pessoa); 
    }

    public List<Pessoa> listar(){
        return this.pessoas; 
    }

    public Pessoa buscaePorCpf(String cpf){
        Pessoa out = null ; 
        for (Pessoa p : pessoas){
            if (p.getCpf().equals(cpf)) {
                out = p; 
                
            }
        }
        return out; 
    }
    public boolean atualizar(String cpf, String telefone, String Cargo ){
        Pessoa p = buscaePorCpf(cpf); 
        boolean out = false; 

        if (p != null) {
            p.setTelefone(telefone);
            p.setCargo(Cargo);
            out = true; 
        }
        return out; 
    }

    public boolean deletar(String cpf){
        Pessoa p =buscaePorCpf(cpf); 
        boolean out = false; 
        if (p != null) {
            this.pessoas.remove(p); 
            out = true; 
            
        }
        return out; 
    }
}
