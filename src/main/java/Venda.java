public class Venda {
    private double total;
    private Cliente cliente;

    public Venda(double total, Cliente cliente) {
        this.total = total;
        this.cliente = cliente;
    }

    public double getTotal() {
        return this.total;
    }

    public void calcularTotal(ItemVenda itemvenda) {
        this.total = itemvenda.getSubTotal();
        if (temDesconto()) {
            this.total = this.total * 0.95;
        }
    }

    public boolean temDesconto() {
        if (this.cliente.getPerfil().getClass() == Premium.class ) {
            return true;
        } else {
            return false;
        }
    }

}