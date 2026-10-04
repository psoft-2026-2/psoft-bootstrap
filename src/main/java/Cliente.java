public class Cliente {
    private String nome;
    private CPF cpf;
    private Perfil perfil;

    public Cliente(String nome, CPF cpf, Perfil perfil) {
        this.nome = nome;
        this.cpf = cpf;
        if (perfil == null) this.perfil = Perfil.criarStandard();
    }

    public String getNome() {
        return nome;
    }

    public CPF getCpf() {
        return cpf;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        if (perfil != null) {
            this.perfil = perfil;
        }
    }
}