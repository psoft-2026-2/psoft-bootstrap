public class EntregaExpressa implements ModalidadeEntrega {
    private static final double TARIFA_FIXA = 10.0;
    private static final double VALOR_POR_KM = 1.5;
    private static final double ADICIONAL_PRIORIDADE = 20.0;

    @Override
    public String getNome() { return "Expressa"; }

    @Override
    public double calcularCusto(Pedido pedido) {
        return TARIFA_FIXA + VALOR_POR_KM * pedido.getDistanciaKm() + ADICIONAL_PRIORIDADE;
    }

    @Override
    public int calcularPrazoDias(Pedido pedido) {
        return 1 + (int) Math.ceil(pedido.getDistanciaKm() / 1000.0);
    }
}