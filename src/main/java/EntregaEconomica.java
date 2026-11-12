public class EntregaEconomica implements ModalidadeEntrega {
    private static final float VALOR_POR_KM = 1.0f;

    @Override
    public float calcularValorEntrega(Pedido pedido) {
        return VALOR_POR_KM * pedido.getDist();
    }
}
