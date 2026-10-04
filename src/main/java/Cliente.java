public class Cliente {
    private String nome;
    private CPF cpf;
    private Perfil perfil;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = new CPF(cpf);
        this.perfil = Perfil.STANDARD;
    }

    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
