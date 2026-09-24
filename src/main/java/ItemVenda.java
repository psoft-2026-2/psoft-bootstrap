public class ItemVenda {
    private int quantidade;
    private Produto produto;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double subTotal() {
        double total = produto.getPreco() * quantidade;
        if (quantidade >= 20) {
            total = total * 0.90;
        }
        return total;
    }
}
