public class Pagamento {

    private double valor;
    private String forma;
    private boolean pago;

    public Pagamento(double valor, String forma) {
        this.valor = valor;
        this.forma = forma;
        this.pago = false;
    }

    public void pagar() {
        pago = true;
    }

    public double adicionar() {
        return valor;
    }

    public String getForma() {
        return forma;
    }

    public boolean getPago() {
        return pago;
    }
}
