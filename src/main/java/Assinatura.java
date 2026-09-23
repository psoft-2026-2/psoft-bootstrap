public enum Assinatura {
    PREMIUM(0.05), 
    STANDARD(0.0);

    private double desconto;

    Assinatura(double desconto) {
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }
}