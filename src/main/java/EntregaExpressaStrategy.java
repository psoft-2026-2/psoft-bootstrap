public class EntregaExpressaStrategy implements EstrategiaEntrega {
    private final double custoAdic;

    public EntregaExpressaStrategy(double custoAdic) {
        if (!Double.isFinite(custoAdic) || custoAdic < 0) {
            throw new IllegalArgumentException("Custo adicional deve ser finito e nao negativo");
        }
        this.custoAdic = custoAdic;
    }

    public double getCustoAdic() {
        return custoAdic;
    }

    public double calculaCusto(Pedido pedido) {
        validarPedido(pedido);
        return custoAdic;
    }

    public int calculaPrazo(Pedido pedido) {
        validarPedido(pedido);
        return 1;
    }

    public String estimaEntrega(Pedido pedido) {
        return "Entrega expressa: R$ " + calculaCusto(pedido) + " em " + calculaPrazo(pedido) + " dia(s)";
    }

    private static void validarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido nao pode ser nulo");
        }
    }

    public String toString() {
        return "EntregaExpressaStrategy{custoAdic=" + custoAdic + "}";
    }
}
