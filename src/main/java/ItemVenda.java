package main.java;
public class ItemVenda {

    private int quantidade;
    private Produto produto;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return produto.getPrecoInicial() * quantidade;
    }

    public double calcularPrecoComDesconto() {
        double subtotal = calcularSubtotal();

        if (quantidade >= 20) {
            return subtotal * 0.90;
        }

        return subtotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }
}