public enum ClientePerfil {

    STANDARD,
    PREMIUM;

    public double calcularDesconto(double valorTotal) {
        
        if (this == PREMIUM) {
            return valorTotal - ( valorTotal * 0.05); 
        } else {
            return valorTotal;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
