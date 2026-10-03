public class Cliente {

    private final String nome;
    private final String cpf;
    private final Perfil perfil;

    public Cliente(String nome, String cpf, Perfil perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.perfil = perfil;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public boolean temDesconto() {
        return perfil.getDesconto() > 0;
    }

    public String getNome() {
        return nome;
    }
}
