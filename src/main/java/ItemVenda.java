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
            subtotal = subtotal * 0.90;
        }

        return subtotal;
    }

    public double getValorUnitario() {
        return produto.getPreco();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }
}
