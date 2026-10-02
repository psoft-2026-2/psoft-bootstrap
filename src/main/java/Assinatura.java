public enum Assinatura {
    STANDARD(0.0),
    PREMIUM(0.05);

    private double percentualDesconto;

    private Assinatura(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }
}
