public enum Assinatura {
    
    STANDARD(1.0),
    PREMIUM(0.95);

    private final double desconto;

    private Assinatura(double desconto) {
        this.desconto = desconto;
    }

    public double calculaDesconto() {
        return desconto;
    }

}