public class EntregaExpressa implements ModalidadeEntrega {
    private static final double TARIFA_BASE = 15.0;
    private static final double VALOR_POR_KM = 2.0;
    private static final double ADICIONAL_PRIORIDADE = 20.0;

    @Override
    public String getNome() { return "Expressa"; }

    @Override
    public double calcularCusto(Pedido p) {
        return TARIFA_BASE + VALOR_POR_KM * p.getDistanciaKm() + ADICIONAL_PRIORIDADE;
    }

    @Override
    public int calcularPrazoDias(Pedido p) {
        return 2;
    }
}
