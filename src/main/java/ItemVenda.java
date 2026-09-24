public class ItemVenda {
    private Produto produto;
    private int qtd;

    public ItemVenda(Produto produto, int qtd) {
        this.produto = produto;
        this.qtd = qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQtd() {
        return qtd;
    }

    public Double calculaDesconto() {
        if (qtd >= 20)
            return produto.getPreco() * 0.9 * qtd;

        return produto.getPreco() * qtd;
    }
    
}
