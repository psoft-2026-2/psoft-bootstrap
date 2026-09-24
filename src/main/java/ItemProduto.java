public class ItemProduto {

    private Produto produto;
    private int qtd;

    public ItemProduto(Produto produto, int qtd) {
        this.produto = produto;
        this.qtd = qtd;
    }


    public double getPreco() {

        double precoSemDesconto = produto.getPreco() * qtd;

        return precoSemDesconto - desconto10();
    }

    private double desconto10() {

        if (qtd >= 20) {
            return produto.getPreco() * qtd * 0.10;
        }

        return 0.0;
    }
}