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

    public double getValorTotal() {
        double total = produto.getPreco() * quantidade;
        if (temDescontoQuantidade()) {
            total = total - (total * 0.1); // Aplica 10% de desconto
        }
        return total;
    }

    public boolean temDescontoQuantidade() {
        if (quantidade >= 20) {
            return true;
        }
        return false;
    }

}
