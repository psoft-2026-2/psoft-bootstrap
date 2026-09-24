public class Itemvenda {
    private Produto produto;
    private int quantidade; 


	public Itemvenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return this.quantidade * this.produto.calcularPrecoUnitarioComDesconto(this.quantidade);
    }

    public Produto getProduto(){ 
        return produto; 
    }

    public int getQuantidade(){ 
        return quantidade; 
    }
}
