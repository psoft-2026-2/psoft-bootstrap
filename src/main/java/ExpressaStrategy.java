public class ExpressaStrategy implements ModalidadeStrategy {
    private static final float VALOR_FIXO   = 5.5f; // Considera o adicional de prioridade, maior VALOR_FIXO
    private static final float VALOR_POR_KM = 1.5f;
    private static final int   TEMPO_FIXO   = 20;   // Considera a prioridade do pedido, menor TEMPO_FIXO
    private static final int   TEMPO_POR_KM = 3;

    @Override
    public float calcularCusto(Pedido pedido) {
        return VALOR_FIXO + VALOR_POR_KM * pedido.getDistancia();
    }

    @Override
    public float calcularPrazo(Pedido pedido) {
        return TEMPO_FIXO + TEMPO_POR_KM * pedido.getDistancia();
    }
}