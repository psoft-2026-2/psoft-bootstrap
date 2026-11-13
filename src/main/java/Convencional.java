public class Convencional implements Modalidade {
    private final int tarifa;

    public Convencional() { this(1000); }

    public Convencional(int tarifa) {
        if (tarifa < 0) throw new IllegalArgumentException("Tarifa não pode ser negativa.");
        this.tarifa = tarifa;
    }

    public int getTarifa() { return tarifa; }

    @Override
    public int custo(Pedido pedido) {
        return Math.addExact(tarifa, Math.multiplyExact(pedido.getDistancia(), 100));
    }

    @Override
    public int prazo(Pedido pedido) {
        return 2 + pedido.getDistancia() / 100 + (pedido.getDistancia() % 100 == 0 ? 0 : 1);
    }
}
