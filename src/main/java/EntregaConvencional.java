public class EntregaConvencional implements ModalidadeEntrega {

    private static final double TARIFA_FIXA = 10.0;
    private static final double VALOR_POR_KM = 1.5;
    private static final double VALOR_POR_KG = 0.5;
    private static final int PRAZO_BASE = 3;
    private static final int KM_POR_DIA = 100;

    @Override
    public double calcularCusto(Pedido pedido) {
        return TARIFA_FIXA + pedido.getDistancia() * VALOR_POR_KM + pedido.getPeso() * VALOR_POR_KG;
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return PRAZO_BASE + (int) (pedido.getDistancia() / KM_POR_DIA);
    }

    @Override
    public String getNome() {
        return "Convencional";
    }
}
