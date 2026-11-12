public class ConvencionalStrategy implements ModalidadeStrategy {
    private static final float VALOR_FIXO   = 3.5f;
    private static final float VALOR_POR_KM = 1.5f;
    private static final int   TEMPO_FIXO   = 30;
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