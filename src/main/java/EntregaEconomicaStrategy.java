public class EntregaEconomicaStrategy implements EstrategiaEntrega {
    private static final double TARIFA_BASE = 20.0;

    private final double desconto;
    private final int prioridade;

    public EntregaEconomicaStrategy(double desconto, int prioridade) {
        if (!Double.isFinite(desconto) || desconto < 0 || desconto > 1) {
            throw new IllegalArgumentException("Desconto deve ser finito e estar entre 0 e 1");
        }
        if (prioridade < 1) {
            throw new IllegalArgumentException("Prioridade deve ser maior ou igual a 1");
        }
        this.desconto = desconto;
        this.prioridade = prioridade;
    }

    public double getDesconto() {
        return desconto;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public double calculaCusto(Pedido pedido) {
        validarPedido(pedido);
        return TARIFA_BASE * (1 - desconto);
    }

    public int calculaPrazo(Pedido pedido) {
        validarPedido(pedido);
        return Math.max(1, 7 - prioridade);
    }

    public String estimaEntrega(Pedido pedido) {
        return "Entrega economica (prioridade " + prioridade + "): R$ " + calculaCusto(pedido)
                + " em " + calculaPrazo(pedido) + " dia(s)";
    }

    private static void validarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido nao pode ser nulo");
        }
    }

    public String toString() {
        return "EntregaEconomicaStrategy{desconto=" + desconto
                + ", prioridade=" + prioridade + "}";
    }
}
