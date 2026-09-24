public class Cliente {
    private String nome;
    private String cpf;
    private Perfil perfilAss;

    public Cliente(String nome, String cpf, Perfil perfilAss) {
        this.nome = nome;
        this.cpf = cpf;
        this.perfilAss = perfilAss;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Perfil getPerfilAss() {
        return this.perfilAss;
    }

    public void mudaPerfilAss(Perfil perfilAss) {
        this.perfilAss = perfilAss;
    }

    public boolean isPremium() {
        return this.perfilAss == Perfil.PREMIUM;
    }
}
