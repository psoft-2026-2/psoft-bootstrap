import java.util.Locale;

public class Cliente {
    public static final String STANDARD = "standard";
    public static final String PREMIUM = "premium";

    private final String id;
    private final String nome;
    private final String assinatura;

    public Cliente(String id, String nome, String assinatura) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("id cliente invalido");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("nome invalido");
        }


        this.id = id.trim();
        this.nome = nome.trim();
        this.assinatura = assinaturaNormalizada;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public double CalculaDescontoAssinatura() {
        return PREMIUM.equals(assinatura) ? 0.05 : 0.0;
    }
}
