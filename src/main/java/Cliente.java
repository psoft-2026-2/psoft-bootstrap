public class Cliente {
    private String cpf;
    private Perfil perfil;

    public Cliente(String cpf, Perfil perfil) {
        this.cpf = cpf;
        this.perfil = perfil;
    }

    public boolean isPremium() {
        return perfil == Perfil.PREMIUM;
    }
}
