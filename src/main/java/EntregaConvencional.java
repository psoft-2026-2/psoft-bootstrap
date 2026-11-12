public class EntregaConvencional implements ModalidadeEntrega {
    private static final float TAXA_FIXA = 10.0f;
    private static final float VALOR_POR_KM = 2.0f;

    @Override
    public float calcularValorEntrega(Pedido pedido) {
        return TAXA_FIXA + VALOR_POR_KM * pedido.getDist();
    }
}
