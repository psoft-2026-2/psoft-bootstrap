public class Cliente {
    private String nome;
    private Perfil perfil;

    public Cliente(String nome, Perfil perfil) {
        this.nome = nome;
        this.perfil = perfil;
    }

    public float getDescontoPerfil() {
        return this.perfil.desconto;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
