public class Pagamento {
    private boolean statusPago;
    private double valorPago;
    
    public Pagamento(boolean statusPago, double valorPago) {
        this.statusPago = statusPago;
        this.valorPago = valorPago;
    }

    public boolean isStatusPago() {
        return statusPago;
    }

    public void setStatusPago(boolean statusPago) {
        this.statusPago = statusPago;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

}
