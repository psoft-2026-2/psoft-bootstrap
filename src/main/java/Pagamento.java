public class Pagamento {
    private double valorPagamento;
    private boolean status;

    public Pagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
        this.status = false;
    }

    public double getValorPagamento() {
        return this.valorPagamento;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void mudaStatus(double valorNec) {
        if (this.valorPagamento >= valorNec)
            this.status = true;
    }
}
