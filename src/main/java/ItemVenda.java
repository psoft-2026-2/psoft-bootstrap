public class ItemDeVenda {
    private Produto produto;
    private int qtd;

    public ItemDeVenda(Produto produto, int qtd) {
        this.produto = produto;
        this.qtd = qtd;
    }

    public double getSubTotal() {
        double valor = produto.getPreco() * qtd;
        if (this.qtd >= 20) {
            valor = valor - (valor * 0.10); 
        }
        return valor;
    }
}