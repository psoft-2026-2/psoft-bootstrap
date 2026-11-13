public class ModalidadeExpressa implements ModalidadeEntrega {

    private static final double TARIFA_FIXA = 10.0;
    private static final double VALOR_POR_KM = 0.50;
    private static final double ADICIONAL_PRIORIDADE = 25.0;
    private static final double KM_POR_DIA = 300.0;

    @Override
    public double calcularCusto(Pedido pedido) {
        return TARIFA_FIXA + VALOR_POR_KM * pedido.getDistanciaEstimada() + ADICIONAL_PRIORIDADE;
    }

    @Override
    public double calcularPrazoEntrega(Pedido pedido) {
        return Math.ceil(pedido.getDistanciaEstimada() / KM_POR_DIA);
    }

    @Override
    public String toString() {
        return "Expressa";
    }
}
