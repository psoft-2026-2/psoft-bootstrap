public class ItemVenda {
    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public double calcularDesconto() {
        return quantidade >= 20 ? calcularSubtotal() * 0.10 : 0.0;
    }
}
