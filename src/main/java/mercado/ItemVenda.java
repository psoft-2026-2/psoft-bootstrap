package mercado;

public class ItemVenda {

    private int quant;
    private Produto produto;

    public ItemVenda(Produto produto, int quant) {
        this.produto = produto;
        this.quant = quant;
    }

    private boolean temDesconto() {
        return quant >= 20;
    }

    public double calcTotalItem() {
        double total = quant * produto.getPreco();
        if (temDesconto()) {
            total -= total * 0.10;
        }
        return total;
    }

}
