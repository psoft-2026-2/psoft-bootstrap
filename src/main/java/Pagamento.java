public class Pagamento {

    private final double valorTotal;
    private final double valorPago;

    public Pagamento(double valorTotal, double valorPago) {
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
    }

    public boolean processar() {
        return valorPago >= valorTotal;
    }

    public double calcularTroco() {
        if (!processar()) {
            return 0.0;
        }
        return valorPago - valorTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getValorPago() {
        return valorPago;
    }
}
