public class Expresso implements Modalidade {
    private final int valorKm;

    public Expresso() { this(150); }

    public Expresso(int valorKm) {
        if (valorKm < 100) throw new IllegalArgumentException("Valor por km deve ser pelo menos 100 centavos.");
        this.valorKm = valorKm;
    }

    public int getValorKm() { return valorKm; }

    @Override
    public int custo(Pedido pedido) {
        int adicional = Math.multiplyExact(pedido.getPrioridade(), 500);
        return Math.addExact(Math.addExact(2000, Math.multiplyExact(pedido.getDistancia(), valorKm)), adicional);
    }

    @Override
    public int prazo(Pedido pedido) {
        return 1 + pedido.getDistancia() / 200 + (pedido.getDistancia() % 200 == 0 ? 0 : 1);
    }
}
