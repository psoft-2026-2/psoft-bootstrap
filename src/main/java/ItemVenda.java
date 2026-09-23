public class ItemVenda {

    private static final int qtdMinDesc = 20;
    private static final double percDesc = 0.10;

    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Information Expert: o item conhece o produto e a quantidade,
     * então é ele quem calcula o subtotal com o desconto por quantidade.
     */
    public double getSubtotal() {
        double subtotal = this.produto.getPreco() * this.quantidade;
        if (this.quantidade >= qtdMinDesc) {
            subtotal *= (1 - percDesc);
        }
        return subtotal;
    }
}
