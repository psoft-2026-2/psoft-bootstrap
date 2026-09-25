public class ItemVenda {
    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }

    public float getSubTotal() {
        float subTotal = produto.getPreco() * quantidade;
        if (quantidade >= 20) {
            subTotal = subTotal - (subTotal * 0.10f);
        }
        return subTotal;
    }
}