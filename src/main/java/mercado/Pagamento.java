package mercado;

public class Pagamento {

    private double totalCompra;
    private double totalPago;
    private String tipoPagamento;

    public Pagamento(double totalCompra, double totalpago, String tipoPagamento) {
        this.totalCompra = totalCompra;
        this.totalPago = totalpago;
        this.tipoPagamento = tipoPagamento;
    }

    public double retornarTroco() {
        if (totalPago > totalCompra) {
            return totalPago - totalCompra;
        }
        return 0;
    }

    public String getExtrato() {
        return "Foi pago: R$" + totalPago + ", " + "em uma compra de: R$" + totalCompra + ", " + "pago com "
                + tipoPagamento;
    }

}
