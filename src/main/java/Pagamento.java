public class Pagamento {
    private final double valorPago;

    public Pagamento(double valorPago) {
        if (!Double.isFinite(valorPago) || valorPago < 0) {
            throw new IllegalArgumentException("Valor pago deve ser finito e nao negativo.");
        }
        this.valorPago = valorPago;
    }

    public double getValorPago() {
        return valorPago;
    }
}
