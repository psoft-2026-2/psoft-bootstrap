public class EntregaConvencional implements ModalidadeEntrega {
    private static final double TARIFA_FIXA = 10.0;
    private static final double VALOR_POR_KM = 1.5;

    @Override
    public String getNome() { return "Convencional"; }

    @Override
    public double calcularCusto(Pedido pedido) {
        return TARIFA_FIXA + VALOR_POR_KM * pedido.getDistanciaKm();
    }

    @Override
    public int calcularPrazoDias(Pedido pedido) {
        return 3 + (int) Math.ceil(pedido.getDistanciaKm() / 500.0);
    }
}