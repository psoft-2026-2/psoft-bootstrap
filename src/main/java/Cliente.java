public class Cliente {

    private String nome;
    private String cpf;
    private String email;
    private Perfil assinatura;

    public Cliente(String nome, String cpf, String email, Perfil assinatura) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.assinatura = assinatura;
    }
    
    public Perfil getPerfilAssinatura() {
        return assinatura;
    }

    public double getDescontoPerfil() {
        return this.assinatura.getDesconto();
    }
}