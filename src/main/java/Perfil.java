public enum Perfil {
    STANDARD(0.0),
    PREMIUM(0.05);

    private final double desconto;

    Perfil(double desconto) {
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }
}
