import java.util.*;

public class Pessoa{
    private String nome;
    private int idade;
    private String cpf;
    private ArrayList<Endereco> enderecos;
    private String telefone;
    private String profissao;

    public Pessoa(String nome, int idade, String cpf, ArrayList<Endereco> enderecos, String telefone, String profissao){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.enderecos = enderecos;
        this.telefone = telefone;
        this.profissao = profissao;
    }

    public String toString(){
        return "Nome: " + this.nome + ".\n" + 
                "Idade: " + this.idade + ".\n" +
                "CPF: " + this.cpf + ".\n" + 
                "Enderecos: " + this.enderecos.toString() + ".\n" + 
                "Telefone: " +  this.telefone + ".\n" +
                "Profissão: " + this.profissao + ".";
                
    }
}