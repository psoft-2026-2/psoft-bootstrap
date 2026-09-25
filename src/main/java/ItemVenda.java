public class ItemVenda {
    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        double subtotal = produto.getPreco() * quantidade;
        if (quantidade >= 20) {
            subtotal = subtotal * 0.9;
        }
        return subtotal;
    }
}