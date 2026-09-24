public class Cliente {

    private static final double PERCENTUAL_DESCONTO_PREMIUM = 0.05;

    private final String id;
    private final String nome;
    private final PerfilAssinatura perfil;

    public Cliente(String id, String nome, PerfilAssinatura perfil) {
        this.id = id;
        this.nome = nome;
        this.perfil = perfil;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public PerfilAssinatura getPerfil() {
        return perfil;
    }

    public boolean elegivelDescontoPremium() {
        return perfil == PerfilAssinatura.PREMIUM;
    }

    public double getPercentualDescontoPremium() {
        return PERCENTUAL_DESCONTO_PREMIUM;
    }

    @Override
    public String toString() {
        return nome + " (" + perfil + ")";
    }
}