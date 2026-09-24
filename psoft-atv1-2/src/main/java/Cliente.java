public class Cliente {
    
    private String nome;
    private String cpf;
    private String telefone;
    private Assinatura perfilAssinatura;

    public Cliente(String nome, String cpf, String telefone, Assinatura perfilAssinatura) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.perfilAssinatura = perfilAssinatura;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }  

    public Assinatura getPerfilAssinatura() {
        return perfilAssinatura;
    }

}
