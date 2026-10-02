public enum Perfil {

    PREMIUM(0.05), 
    STANDARD(0.0);

    private double desconto;

    Perfil(double desconto) {
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }

}
