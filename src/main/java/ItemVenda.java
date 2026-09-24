public class ItemVenda {
    private int quantidade;
    private double subtotal;

    public ItemVenda(int quantidade, double subtotal) {
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }

    public boolean temDesconto() {
        if (this.quantidade != 20) {
            return false;
        } else {
            return true;
        }
    }

    public void calcularSubtotal(Produto produto) {
        if (temDesconto() == false) {
            this.subtotal = this.quantidade * produto.getPreco();
        } else {
            this.subtotal = this.quantidade * aplicarDesconto(produto);
        }
        
    }

    public double aplicarDesconto(Produto produto) {
        return produto.getPreco() * 0.2;
    }

    public double getSubTotal() {
        return this.subtotal;
    }
}