public class ItemVenda {
    private int quantidade;
    private Produto produto;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() { 
        double precoBruto = produto.getPreco() * quantidade; 
        double desconto = calculaDesconto(quantidade); 
        return precoBruto * (1.0 - desconto); 
    }

    public double calculaDesconto(int quantidade) {
        if (quantidade >= 20) {
            return 0.10;
        }
        return 0.0;
    }

    public Produto getProduto() {
        return produto;
    }
    
}