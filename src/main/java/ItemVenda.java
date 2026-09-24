public class ItemVenda {
    private final int quantidade;
    private final Produto produto;

    public ItemVenda(Produto produto, int quantidade) {
        if (produto == null || quantidade <= 0) {
            throw new IllegalArgumentException("Informe um produto e quantidade positiva.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        double subtotal = produto.getPrecoBase() * quantidade;
        return quantidade >= 20 ? subtotal * 0.90 : subtotal;
    }
}
