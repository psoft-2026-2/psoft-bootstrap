public class EntregaEconomica implements Entrega {

    @Override
    public double calcularCusto(Pedido pedido) {
        return pedido.getPeso() * 1.5 + pedido.getDistancia() * 0.3;
    }

    @Override
    public double calcularTempo(Pedido pedido) {
        return pedido.getDistancia() / 30.0 + 1.0;
    }
}
