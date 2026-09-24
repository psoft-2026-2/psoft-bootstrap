public class ItemVenda {

    private static final int QUANTIDADE_MINIMA_DESCONTO = 20;
    private static final double PERCENTUAL_DESCONTO_QUANTIDADE = 0.10;

    private final Produto produto;
    private final int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }
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


    public double getSubTotal() {
        double valorBruto = produto.getPrecoUnitario() * quantidade;
        if (quantidade >= QUANTIDADE_MINIMA_DESCONTO) {
            return valorBruto * (1 - PERCENTUAL_DESCONTO_QUANTIDADE);
        }
        return valorBruto;
    }
}