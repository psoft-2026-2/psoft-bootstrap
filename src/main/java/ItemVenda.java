public class ItemVenda {
    private Produto produto;
    private int qtd;

    public ItemVenda(Produto produto, int qtd) {
        this.produto = produto;
        this.qtd = qtd;
    }

    public float subTotal() {
        return qtd * produto.getValor() * this.desconto();
    }

    public float desconto() {
        float desc = 1;
        if (this.qtd >= 20)
            desc = 0.9f;

        return desc;
    }
}
