public class ItemVenda {
    private Produto produto;
    private int qtd;

    public ItemVenda(Produto produto, int qtd) {
        this.produto = produto;
        this.qtd = qtd;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public int getQtd() {
        return this.qtd;
    }

    public float valorTotal() {
        float total = produto.getPreco() * this.qtd;
        if (this.qtd >= 20) {
            total = total * 0.9f;
        }
        return total;
    }
}