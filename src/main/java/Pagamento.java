public class Pagamento {
    private String tipoPagamento;
    private float taxa;
    private boolean fechado;

    public Pagamento(String tipoPagamento, float taxa) {
        this.tipoPagamento = tipoPagamento;
        this.taxa = taxa;
        this.fechado = false;
    }

    public void fechar() {
        fechado = true;
    }

    public float getTaxa() {
        return taxa;
    }

    public String getTipo() {
        return tipoPagamento;
    }

    public boolean isClosed() {
        return fechado;
    }
}
