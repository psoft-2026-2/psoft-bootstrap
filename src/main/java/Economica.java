public class Economica implements ModalidadeEntrega {
    private static final float TARIFA_FIXA = 6.0f;
    private static final float VALOR_POR_KM = 0.30f;

    public Economica() {
    }

    @Override
    public float calcularCusto() {
        return TARIFA_FIXA;
    }

    @Override
    public float calcularCusto(float distancia) {
        return calcularCusto() + distancia * VALOR_POR_KM;
    }

    @Override
    public int calcularPrazo() {
        return 8;
    }
}
