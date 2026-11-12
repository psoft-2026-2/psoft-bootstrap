package atv5;

public class Cliente {
    
    private int idCliente;
    private String nome;
    private String cpf;
    private Endereco endereco;

    public Cliente(int idCliente, String nome, String cpf, Endereco endereco) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public int getIdCliente() { 
        return idCliente; 
    }
    public String getNome() { return nome; 

    }
    public String getCpf() { 
        return cpf; 
    }
    public Endereco getEndereco() { 
        return endereco; 
    }
}
