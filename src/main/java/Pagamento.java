public class Pagamento {
    
    private double valorPago;
    private String metodo;
    
    public Pagamento(double valorPago, String metodo) {
        this.valorPago = valorPago;
        this.metodo = metodo;
    }

    public double getValorPago() {
        return valorPago;
    }

    public String getMetodo() {
        return metodo;
    }
}
