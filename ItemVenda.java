public class ItemVenda {
    private int quantidade;
    private Produto produto;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        double totalSemDesconto = produto.getPrecoBase() * quantidade;
        
        if (this.quantidade >= 20) {
            return totalSemDesconto * 0.90;
        }
        
        return totalSemDesconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }
}