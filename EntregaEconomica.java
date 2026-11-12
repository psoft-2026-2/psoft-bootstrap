public class EntregaEconomica implements ModalidadeEntrega {
    private static final double TARIFA_FIXA = 5.0;
    private static final double VALOR_POR_KM = 0.8;

    @Override
    public String getNome() { return "Econômica"; }

    @Override
    public double calcularCusto(Pedido pedido) {
        return TARIFA_FIXA + VALOR_POR_KM * pedido.getDistanciaKm();
    }

    @Override
    public int calcularPrazoDias(Pedido pedido) {
        return 7 + (int) Math.ceil(pedido.getDistanciaKm() / 300.0);
    }
}