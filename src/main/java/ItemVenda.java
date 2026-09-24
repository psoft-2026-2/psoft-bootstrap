public class ItemVenda {
    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double CalcularSubTotal() {
        double subtotal = produto.getPreco() * quantidade;
        if (this.quantidade >= 20) {
            subtotal *= 0.90;
        }
        return subtotal;
    }
}