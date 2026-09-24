public class Cliente {
    private String cpf;
    private String nome;
    private PerfilAssinatura perfil;

    public Cliente(String cpf, String nome, PerfilAssinatura perfil) {
        this.cpf = cpf;
        this.nome = nome;
        this.perfil = perfil;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public PerfilAssinatura getPerfil() {
        return perfil;
    }

    public double getDescontoCliente() {
        if (this.perfil == PerfilAssinatura.PREMIUM) {
            return 0.05; 
        }
        return 0.0; 
    }
}
