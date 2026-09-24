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

    public double valorComDesc() {
        double valorUnitario = produto.getPreco();
        if (this.quantidade >= 20) {
            valorUnitario = produto.getPreco() - (produto.getPreco() * 0.1);
        }
        return valorUnitario * this.quantidade;
    }

    @Override
    public String toString() {
        return produto.toString() + " - quantidade: " + this.quantidade + " - valor final: R$" + valorComDesc();
    }
}
