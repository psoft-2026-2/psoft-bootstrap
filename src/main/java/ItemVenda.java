public class ItemVenda {
    private Produto produto;
    private int quantidade;

    ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double CalculaVal(){
        double val = produto.getPreco() * quantidade;
        if(CalculaDesconto()){
            val -= (val * 0.1);
        }
        return val;
    }

    public boolean CalculaDesconto(){
        return quantidade >= 20;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
}
