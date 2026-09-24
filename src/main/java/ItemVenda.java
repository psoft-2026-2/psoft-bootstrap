public class ItemVenda {
    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        double precoBaseTotal = produto.getPrecoBase() * quantidade;

        if (quantidade >= 20) {
            return precoBaseTotal * 0.90;
        }

        return precoBaseTotal;
    }
}