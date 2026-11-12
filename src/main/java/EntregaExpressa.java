public class EntregaExpressa implements ModalidadeEntrega {
    private static final double TARIFA_FIXA = 10.0;
    private static final double VALOR_POR_KM = 1.5;
    private static final double ADICIONAL_PRIORIDADE = 20.0;

    @Override
    public double calcularCusto(Pedido p) {
        return TARIFA_FIXA + VALOR_POR_KM * p.getDistancia() + ADICIONAL_PRIORIDADE;
    }

    @Override
    public int calcularPrazo(Pedido p) {
        return 1 + (int) (p.getDistancia() / 500);
    }
}
