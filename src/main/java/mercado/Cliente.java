package mercado;

public class Cliente {

    private String nome;
    private Perfil perfil;

    public Cliente(String nome, Perfil perfil) {
        this.nome = nome;
        this.perfil = perfil;
    }

    // Information Expert: conhece o próprio perfil.
    public Perfil getPerfil() {
        return perfil;
    }
}
