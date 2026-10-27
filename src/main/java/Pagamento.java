public class Pagamento {

    public static final double DESCONTO_PREMIUM = 0.10;

    private Cliente cliente;
    private Pedido pedido;
    private double valorPago;

    public Pagamento(Cliente cliente, Pedido pedido) {
        this.cliente = cliente;
        this.pedido = pedido;

        double desconto = cliente.isPremium() ? DESCONTO_PREMIUM : 0;
        valorPago = pedido.getValorTotal() * (1 - desconto);

        pedido.pagarPedido();
    }

    public Cliente getCliente() {return cliente;}

    public Pedido getPedido() {return pedido;}

    public double getValorPago() {return valorPago;}

    @Override
    public String toString() {
        return String.format("Pagamento [cliente=%s, pedido=%d, valorPago=R$ %.2f]",
                cliente.getNome(), pedido.getId(), valorPago);
    }
}
