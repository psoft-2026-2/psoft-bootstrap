public class Pagamento {
    private float valor;
    private FormaPag forma;

    public Pagamento(float valor, FormaPag forma) {
        this.valor = valor;
        this.forma = forma;
    }

    public float getValor() {
        return this.valor;
    }

    public FormaPag getForma() {
        return this.forma;
    }
}
