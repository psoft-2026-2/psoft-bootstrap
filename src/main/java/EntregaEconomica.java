public class EntregaEconomica implements ModalidadeEntrega {

    private static final double TARIFA_FIXA = 5.0;
    private static final double VALOR_POR_KM = 0.8;
    private static final double VALOR_POR_KG = 0.3;
    private static final int PRAZO_BASE = 7;
    private static final int KM_POR_DIA = 50;

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
        return "Economica";
    }
}
