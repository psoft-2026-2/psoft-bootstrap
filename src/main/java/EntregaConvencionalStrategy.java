public class EntregaConvencionalStrategy implements EstrategiaEntrega {
    private final double tarifa;

    public EntregaConvencionalStrategy(double tarifa) {
        if (!Double.isFinite(tarifa) || tarifa < 0) {
            throw new IllegalArgumentException("Tarifa deve ser finita e nao negativa");
        }
        this.tarifa = tarifa;
    }

    public double getTarifa() {
        return tarifa;
    }

    public double calculaCusto(Pedido pedido) {
        validarPedido(pedido);
        return tarifa * pedido.getDistancia();
    }

    public int calculaPrazo(Pedido pedido) {
        validarPedido(pedido);
        return Math.max(1, (int) Math.ceil(pedido.getDistancia() / 50.0));
    }

    public String estimaEntrega(Pedido pedido) {
        return "Entrega convencional: R$ " + calculaCusto(pedido)
                + " em " + calculaPrazo(pedido) + " dia(s)";
    }

    private static void validarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido nao pode ser nulo");
        }
    }

    public String toString() {
        return "EntregaConvencionalStrategy{tarifa=" + tarifa + "}";
    }
}
