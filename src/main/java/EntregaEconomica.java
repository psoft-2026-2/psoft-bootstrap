public class EntregaEconomica implements ModalidadeEntrega {
    private static final double TARIFA_BASE = 5.0;
    private static final double VALOR_POR_KM = 0.8;

    @Override
    public String getNome() { return "Economica"; }

    @Override
    public double calcularCusto(Pedido p) {
        return TARIFA_BASE + VALOR_POR_KM * p.getDistanciaKm();
    }

    @Override
    public int calcularPrazoDias(Pedido p) {
        return 15;
    }
}
