public class EntregaConvencional implements ModalidadeEntrega {
    private static final double TARIFA_FIXA = 10.0;
    private static final double VALOR_POR_KM = 1.5;

    @Override
    public double calcularCusto(Pedido p) {
        return TARIFA_FIXA + VALOR_POR_KM * p.getDistancia();
    }

    @Override
    public int calcularPrazo(Pedido p) {
        return 5 + (int) (p.getDistancia() / 200);
    }
}
