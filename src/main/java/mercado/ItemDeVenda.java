package mercado;

public class ItemDeVenda {

    private static final int QUANTIDADE_MINIMA_PARA_DESCONTO = 20;
    private static final float PERCENTUAL_DESCONTO_QUANTIDADE = 0.10f;

    private int qnt;
    private Produto produto;
    private float subtotal;

    public ItemDeVenda(int qnt, Produto produto) {
        this.qnt = qnt;
        this.produto = produto;
        this.subtotal = calculaSubtotal();
    }

    public float calculaSubtotal() {
        float valor = produto.getPreco() * qnt;
        if (recebeDesconto()) {
            valor = aplicaDesconto(valor);
        }
        this.subtotal = valor;
        return valor;
    }

    public boolean recebeDesconto() {
        return qnt >= QUANTIDADE_MINIMA_PARA_DESCONTO;
    }

    public float aplicaDesconto(float valor) {
        return valor * (1 - PERCENTUAL_DESCONTO_QUANTIDADE);
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
        calculaSubtotal();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        calculaSubtotal();
    }

    public float getSubtotal() {
        return subtotal;
    }
}