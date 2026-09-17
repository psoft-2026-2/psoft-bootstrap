package pessoa;

import java.util.List;
import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private String cpf;
    private int idade;
    private String telefone;
    private String profissao;
    private List<Endereco> enderecos;

    public Pessoa(String nome, String cpf, int idade, String telefone, String profissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.profissao = profissao;
        this.enderecos = new ArrayList<>();
    }

    public String getCpf() { 
        return cpf; 
    }

    public String getNome() { 
        return nome; 
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade() { 
        return idade; 
    }

    public void setIdade(int idade) { 
        this.idade = idade; 
    }

    public String getTelefone() { 
        return telefone; 
    }

    public void setTelefone(String telefone) { 
        this.telefone = telefone; 
    }

    public String getProfissao() { 
        return profissao; 
    }

    public void setProfissao(String profissao) { 
        this.profissao = profissao; 
    }

    public List<Endereco> getEnderecos() { 
        return enderecos; 
    }
}