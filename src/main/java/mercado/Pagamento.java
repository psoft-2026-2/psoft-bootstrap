package mercado;

public class Pagamento {

    private double valorPago;

    public Pagamento(double valorPago) {
        this.valorPago = valorPago;
    }

    // Information Expert: conhece o valor pago.
    public double getValorPago() {
        return valorPago;
    }
}
