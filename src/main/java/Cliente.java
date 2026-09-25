public class Cliente {
    private String cpf;
    private Perfil perfil;

    public Cliente(String cpf, Perfil perfil) {
        this.cpf = cpf;
        this.perfil = perfil;
    }

    public String getCpf() { return cpf; }
    public Perfil getPerfil() { return perfil; }

    public float aplicarDesconto(float valor) {
        if (perfil == Perfil.PREMIUM) {
            return (valor - (valor * 0.05f)); 
        }
        return valor;
    }
}