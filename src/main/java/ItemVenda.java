public class ItemVenda {

    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calculaPreco(){
        if(quantidade >= 20)
            return (produto.getValor() * quantidade) * 0.9;
        else
            return produto.getValor() * quantidade;
    }

    public Produto getProduto(){
        return this.produto;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public void setProduto(Produto novo){
        this.produto = novo;
    }

    public void setQuantidade(int nova){
        this.quantidade = nova;
    }
}
