public class ItemVenda {
    private Produto produto;
    private int quantidade;
    
    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double getSubTotal(){
        return this.quantidade * produto.getPreco();
    }
    
    public double getTotal(){
        if (quantidade >= 20){
            // possui desconto
            return getSubTotal() * 0.9;
        }   
        
        return  getSubTotal();
    }

    public Produto getProduto() {
        return produto;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    @Override
    public String toString() {
        return "ItemVenda [produto=" + produto + ", quantidade=" + quantidade + "]";
    }
}
