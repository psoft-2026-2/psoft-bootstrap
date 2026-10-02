package model;

public class ItemVenda {

    private static final int QUANTIDADE_MINIMA_DESCONTO = 20;
    private static final double PERCENTUAL_DESCONTO = 0.10;
    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        double valorBruto = produto.getPreco() * quantidade;
        if (temDesconto()) {
            valorBruto -= valorBruto * PERCENTUAL_DESCONTO;
        }
        return valorBruto;
    }

    public boolean temDesconto() {
        return quantidade >= QUANTIDADE_MINIMA_DESCONTO;
    }

    public double getDesconto() {
        return temDesconto() ? PERCENTUAL_DESCONTO: 0.0;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
