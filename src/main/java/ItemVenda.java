public class ItemVenda {

    private int quantidade;
    private Produto produto;

    public ItemVenda(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public double calcularSubtotal() {
        double subtotal = quantidade * produto.getPreco();

        if (quantidade >= 20) {
            subtotal *= 0.90;
        }

        return subtotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }
}
