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

    public double calcularSubtotal(){
        if(this.quantidade >= 20)
            return this.produto.getPreco() * this.quantidade * 0.9;
        else
            return this.produto.getPreco() * this.quantidade;
    }

    @Override
    public String toString(){
        return "Item Venda: " + this.quantidade + "x " + this.produto;
    }
}
