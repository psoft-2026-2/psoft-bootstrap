public class EntregaConvencional extends Entrega {

    private static final float TARIFA_FIXA = 10.0f;
    private static final float VALOR_POR_KM = 0.5f;

    public EntregaConvencional(float distancia, float peso) {
        super(distancia, peso);
    }

    @Override
    public float calcularPreco() {
        return TARIFA_FIXA + getDistancia() * VALOR_POR_KM;
    }

    @Override
    public int calcularPrazo() {
        return 3 + (int) Math.ceil(getDistancia() / 200);
    }
}
