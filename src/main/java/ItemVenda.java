public class ItemVenda {
    
    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcularSubTotal() {
        if (quantidade >= 20) {
            return produto.getValor() * quantidade * 0.9;
        }

        return produto.getValor() * quantidade;
    }

}