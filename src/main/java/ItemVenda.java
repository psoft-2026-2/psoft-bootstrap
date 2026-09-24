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

    public double calcularSubtotal() {
        
       double subtotal = produto.getPreco() * quantidade;

       if (quantidade >= 20) {
        subtotal -= subtotal * 0.10;
        }
        return subtotal;
    }

    @Override
    public String toString() {
        return "ItemVenda [produto=" + produto + ", quantidade=" + quantidade + "]";
    }

}
