public class Pagamento {

    private String metodo;
    private double valorPago;

    public Pagamento(String metodo, double valorPago) {
        this.metodo = metodo;
        this.valorPago = valorPago;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    @Override
    public String toString() {
        return "Pagamento [metodo=" + metodo + ", valorPago=" + valorPago + "]";
    }

}
