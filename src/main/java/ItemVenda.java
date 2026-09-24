public class ItemVenda {
    private Produto produto;
    private int qtd;

    public ItemVenda(Produto produto, int qtd) {
        this.produto = produto;
        this.qtd = qtd;
    }

    public float calculaSubTotal() {
        float valorTotal = produto.getPreco() * qtd;
        return valorTotal - valorTotal * calculaDesconto();
    }

    public float calculaDesconto() {
        return qtd >= 20 ? 0.1f : 0.0f;
    }
}
