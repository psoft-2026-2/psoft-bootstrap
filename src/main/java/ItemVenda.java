public class ItemVenda {
    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        double subtotalBruto = produto.getPrecoBase() * quantidade;
        
        if (this.quantidade >= 20) {
            return subtotalBruto * 0.90; 
        }
        return subtotalBruto;
    }
}