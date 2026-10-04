public class Venda {

    private Cliente cliente;
    private Pagamento pagamento;
    private ItemProduto itemProduto;

    public Venda(Cliente cliente, Pagamento pagamento, ItemProduto itemProduto) {
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.itemProduto = itemProduto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public ItemProduto getItemProduto() {
        return itemProduto;
    }

    // Regra de negócio: além do desconto por quantidade (já aplicado em Produto),
    // clientes com assinatura "premium" recebem 5% de desconto adicional sobre o total da venda.
    public double calcularDescontoTotal() {
        double total = itemProduto.calcularTotal();
        if (cliente.getAssinatura().equalsIgnoreCase("premium")) {
            total = total * 0.95;
        }
        return total;
    }
}