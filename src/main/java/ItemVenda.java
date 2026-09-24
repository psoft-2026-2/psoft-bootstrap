public class ItemVenda {

    private final Produto produto;
    private final int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
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

    public double calcularSubtotal() {
        double precoUnitario = produto.calcularPrecoUnitarioComDesconto(quantidade);
        return precoUnitario * quantidade;
    }

    @Override
    public String toString() {
        return String.format("%dx %s = R$ %.2f", quantidade, produto.getNome(), calcularSubtotal());
    }
}
