public class ItemVenda {
    private Produto produto;
    private int qtdProduto;
    private double subTotal;

    public ItemVenda(Produto produto, int qtdProduto) {
        this.produto = produto;
        this.qtdProduto = qtdProduto;
        calculaSubTotal();
    }

    private void calculaSubTotal() {
        double subTotalTemp = this.produto.getPreco() * this.qtdProduto;

        if (this.qtdProduto >= 20) {
            this.subTotal = subTotalTemp - (subTotalTemp * 0.10);
        } else {
            this.subTotal = subTotalTemp;
        } 
    }

    public void aumentaQtdProduto(int qtdProduto) {
        this.qtdProduto += qtdProduto;
        calculaSubTotal();
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public double getSubTotal() {
        return subTotal;
    }

    @Override
    public String toString() {
        return "ItemVenda [produto=" + produto + ", qtdProduto=" + qtdProduto + ", subTotal=" + subTotal + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((produto == null) ? 0 : produto.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemVenda other = (ItemVenda) obj;
        if (produto == null) {
            if (other.produto != null)
                return false;
        } else if (!produto.equals(other.produto))
            return false;
        return true;
    }
}

