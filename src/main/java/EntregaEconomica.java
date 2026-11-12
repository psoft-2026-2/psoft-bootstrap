public class EntregaEconomica implements ModalidadeEntrega {
    private static final double TARIFA_FIXA = 5.0;
    private static final double VALOR_POR_KM = 0.8;

    @Override
    public double calcularCusto(Pedido p) {
        return TARIFA_FIXA + VALOR_POR_KM * p.getDistancia();
    }

    @Override
    public int calcularPrazo(Pedido p) {
        return 10 + (int) (p.getDistancia() / 100);
    }
}
