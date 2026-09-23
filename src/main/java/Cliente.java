public class Cliente {

    private String nome;
    private String cpf;
    private PerfilAssinatura perfil;

    public Cliente(String nome, String cpf, PerfilAssinatura perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.perfil = perfil;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return cpf;
    }

    public PerfilAssinatura getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilAssinatura perfil) {
        this.perfil = perfil;
    }

    public double aplicarDesconto(double valor) {
        return this.perfil.aplicarDesconto(valor);
    }
}
