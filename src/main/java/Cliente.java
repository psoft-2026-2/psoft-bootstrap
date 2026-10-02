
public class Cliente {
    private String cpf;
    private String nome;
    private Perfil perfil;

    public Cliente(String cpf, String nome, Perfil perfil) {
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
    public Perfil getPerfil() {
        return perfil;
    }


}
