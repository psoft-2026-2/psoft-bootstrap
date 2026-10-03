public class ItemVenda {

    private int quantidade;
    private double subtotal;
    private final double desconto = 0.10;
    private final Produto produto;

    public ItemVenda(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public double calculaSubtotal() {
        subtotal = quantidade * produto.getValor();

        if (aplicaDesconto()) {
            subtotal = subtotal * (1 - desconto);
        }

        return subtotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public boolean aplicaDesconto() {
        return quantidade >= 20;
    }

    public void setQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
