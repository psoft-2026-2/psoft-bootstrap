public class Economica implements Modalidade {
    @Override
    public int custo(Pedido pedido) {
        return Math.addExact(500, Math.multiplyExact(pedido.getDistancia(), 50));
    }

    @Override
    public int prazo(Pedido pedido) {
        return 5 + pedido.getDistancia() / 100 + (pedido.getDistancia() % 100 == 0 ? 0 : 1);
    }
}
