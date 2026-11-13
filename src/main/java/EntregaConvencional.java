public class EntregaConvencional implements Entrega {

    @Override
    public double calcularCusto(Pedido pedido) {
        return pedido.getPeso() * 2.0 + pedido.getDistancia() * 0.5;
    }

    @Override
    public double calcularTempo(Pedido pedido) {
        return pedido.getDistancia() / 50.0;
    }
}
