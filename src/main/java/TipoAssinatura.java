public enum TipoAssinatura {
    STANDARD(0.0),
    PREMIUM(0.05); // 5% de desconto

    private final double percentualDesconto;

    TipoAssinatura(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }
}