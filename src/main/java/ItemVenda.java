public class ItemVenda {
    private final Produto produto;
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

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        if (this.quantidade >= 20) {
            return produto.getPreco() * quantidade * 0.9; // 10% de desconto para compras de 20 ou mais unidades
        }
        else {
            return produto.getPreco() * quantidade;
        }
    }
}
