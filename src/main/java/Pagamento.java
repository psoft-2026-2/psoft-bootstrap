public class Pagamento {

    private double valor;
    private String metodo;

    public Pagamento(String metodo, double valor) {
        this.valor = valor;
        this.metodo = metodo;
    }

    public double getValor() {
        return valor;
    }

    public String getMetodo() {
        return metodo;
    }

}