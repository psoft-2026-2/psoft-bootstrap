public class Pagamento {

    private boolean pago;
    private String metodo;
    private final double valor;

    public Pagamento(String metodo, double valor) {
        this.metodo = metodo;
        this.valor = valor;
        this.pago = false;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public double getValor() {
        return valor;
    }

    public boolean taPago() {
        this.pago = true;
        return this.pago;
    }

}
