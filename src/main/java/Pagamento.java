public class Pagamento {
    private int idPag;
    private float valor;
    private TipoPag tipo;

    public Pagamento(int idPag, float valor, TipoPag tipo) {
        this.idPag = idPag;
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getId() {
        return idPag;
    }

    public TipoPag getTipo() {
        return tipo;
    }

    public float getValor() {
        return valor;
    }
}
