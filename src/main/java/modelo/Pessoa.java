package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    private final String nome; 
    private final String cpf;
    private String telefone; 
    private String cargo;
    private List<Endereco> endereco;

    
    public Pessoa(String nome, String cpf, String telefone, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cargo = cargo;
        this.endereco = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public List<Endereco> getEndereco() {
        return endereco;
    }
    
    public void adicionarEndereco(Endereco endereco){
        this.endereco.add(endereco); 
    }
    public void removerEndereco(Endereco endereco){
        this.endereco.remove(endereco);
    }

     

}
