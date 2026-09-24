public class Cliente {
    private String nome;
    private PerfilAssinatura perfil;

    public Cliente(String nome, PerfilAssinatura perfil) {
        this.nome = nome;
        this.perfil = perfil;
    }
    
    public PerfilAssinatura getPerfil() {
        return perfil;
    }
}