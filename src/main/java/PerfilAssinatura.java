/**
 * Perfil de assinatura do cliente.
 * Information Expert: cada perfil conhece o seu próprio percentual de desconto.
 */
public enum PerfilAssinatura {

    STANDARD(0.0),
    PREMIUM(0.05);

    private final double percentual;

    PerfilAssinatura(double percentual) {
        this.percentual = percentual;
    }

    public double getPercentualDesconto() {
        return percentual;
    }

    public double aplicarDesconto(double valor) {
        return valor * (1 - this.percentual);
    }
}
