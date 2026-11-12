package mercado;

public class ItemVenda {

    private static final int QUANTIDADE_MINIMA_PARA_DESCONTO = 20;
    private static final double PERCENTUAL_DESCONTO = 0.10;

    private int quantidade;
    private Produto produto;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    // Information Expert: conhece produto e quantidade, então calcula o próprio total.
    public double calcularTotal() {
        double preco = produto.getPrecoInicial();
        if (quantidade >= QUANTIDADE_MINIMA_PARA_DESCONTO) {
            preco -= preco * PERCENTUAL_DESCONTO;
        }
        return preco * quantidade;
    }
}
