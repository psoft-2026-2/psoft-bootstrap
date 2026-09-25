public enum PerfilAssinatura {
    STANDARD(0.0),
    PREMIUM(0.05);

    private double desconto;

    PerfilAssinatura(double desconto) {
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }
}