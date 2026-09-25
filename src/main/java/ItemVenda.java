public class ItemVenda {
    private int qtd;
    private Produto produto;

    public ItemVenda(Produto produto, int qtd) {
        if (produto == null)
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        if (qtd <= 0)
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        this.produto = produto;
        this.qtd = qtd;
    }

    public double calculaTotal() {
        return calculaDesconto() * qtd ;
    }

    public double calculaDesconto() {
        if (temDesconto()) return this.getProduto().getPreco() * 0.1;

        return this.getProduto().getPreco();
    }

    public boolean temDesconto() {
        return this.qtd >= 20;
    }

    public int getQtd() {
        return qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public String toString() {
        return "ItemVenda{qtd=" + qtd + ", produto=" + produto +
                ", total=" + calculaTotal() + ", desconto=" + calculaDesconto() + "}";
    }
}
