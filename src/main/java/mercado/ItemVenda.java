package mercado;


public class ItemVenda {
    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        double valorBruto = produto.getPrecoBase() * quantidade;

        if (this.quantidade >= 20) {
            return valorBruto * 0.90;
        }
        
        return valorBruto;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
