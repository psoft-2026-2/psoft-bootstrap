public class ItemVenda {
    private Produto produto;
    private int qtd;
    private float valorTotal;

    public ItemVenda(Produto produto, int qtd) {
        this.produto = produto;
        this.qtd = qtd;
        calculaTotal();
    }

    public float calculaTotal() {
        valorTotal = produto.getPreco() * qtd;
        return valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
        calculaTotal();
    }
}
