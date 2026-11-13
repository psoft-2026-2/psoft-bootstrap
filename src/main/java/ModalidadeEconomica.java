public class ModalidadeEconomica implements ModalidadeEntrega {

    private static final double TARIFA_FIXA = 5.0;
    private static final double VALOR_POR_KM = 0.30;
    private static final double KM_POR_DIA = 50.0;

    @Override
    public double calcularCusto(Pedido pedido) {
        return TARIFA_FIXA + VALOR_POR_KM * pedido.getDistanciaEstimada();
    }

    @Override
    public double calcularPrazoEntrega(Pedido pedido) {
        return Math.ceil(pedido.getDistanciaEstimada() / KM_POR_DIA) + 5;
    }

    @Override
    public String toString() {
        return "Econômica";
    }
}
