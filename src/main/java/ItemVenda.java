package br.edu.ufcg.psoft.mercado;

public class ItemVenda {

    private Produto produto;
    private int quantidade;
    private static final int QTD_DESCONTO = 20;
    private static final double DESCONTO = 0.10;

    ItemVenda(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
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
        double subtotal = produto.getPreco() * quantidade;
        if (quantidade >= QTD_DESCONTO) {
            subtotal = subtotal - subtotal * DESCONTO;
        }
        return subtotal;
    }
}