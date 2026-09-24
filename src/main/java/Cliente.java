public class Cliente {

    private String nome;
    private Perfil perfil;
    private String cpf;

    public Cliente(String nome, Perfil perfil, String cpf) {
        this.nome = nome;
        this.perfil = perfil;
        this.cpf = cpf;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getNome() {
        return nome;
    }

    public Perfil getPerfil() {
        return perfil;
    }
}
