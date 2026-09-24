public class Cliente {
    private  String nome; 
    private  String cpf; 
    private Status status;
    
    public Cliente(String nome, String cpf, Status status) {
        this.nome = nome;
        this.cpf = cpf;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

 

    public Status getStatus() {
        return status;
    }

  
    
}
