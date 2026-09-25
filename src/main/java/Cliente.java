public class Cliente {
    private String nome;
    private PerfilAssinatura perfil;

    public Cliente(String nome, PerfilAssinatura perfil) {
        this.nome = nome;
        this.perfil = perfil;
    }

    public double getDesconto() {
        return perfil.getDesconto();
    }

    public String getNome() {
        return nome;
    }
}