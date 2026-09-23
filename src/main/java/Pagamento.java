public class Pagamento {

    private double valor;
    private FormaPagamento forma;

    public Pagamento(double valor, FormaPagamento forma) {
        this.valor = valor;
        this.forma = forma;
    }

    public double getValor() {
        return valor;
    }

    public FormaPagamento getForma() {
        return forma;
    }
}
