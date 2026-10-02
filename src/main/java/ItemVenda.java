public class ItemVenda{
    private int quantidade;
    private Produto produto;

    public ItemVenda(int quantidade, Produto produto){
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public double calcularPreco(){
        double valor = produto.getPreco() * quantidade;
        if (quantidade >= 20) {
            return valor * 0.9;            
        }else {
            return valor;
        }
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public Produto getProduto(){
        return this.produto;
    }

    public void setQuantidade(int i){
        this.quantidade = i;
    }
}