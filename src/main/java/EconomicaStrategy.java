public class EconomicaStrategy implements ModalidadeStrategy {
    private static final float VALOR_FIXO   = 1.5f; // Considera o preço reduzido, menor VALOR_FIXO e VALOR_POR_KM
    private static final float VALOR_POR_KM = 1f;
    private static final int   TEMPO_FIXO   = 45;   // Considera o prazo maior, maior TEMPO_FIXO e TEMPO_POR_KM
    private static final float TEMPO_POR_KM = 3.5f;

    @Override
    public float calcularCusto(Pedido pedido) {
        return VALOR_FIXO + VALOR_POR_KM * pedido.getDistancia();
    }

    @Override
    public float calcularPrazo(Pedido pedido) {
        return TEMPO_FIXO + TEMPO_POR_KM * pedido.getDistancia();
    }
}