public class EntregaExpressa extends Entrega {

    private static final float TARIFA_FIXA = 10.0f;
    private static final float VALOR_POR_KM = 0.5f;
    private static final float ADICIONAL_PRIORIDADE = 25.0f;

    public EntregaExpressa(float distancia, float peso) {
        super(distancia, peso);
    }

    @Override
    public float calcularPreco() {
        return TARIFA_FIXA + getDistancia() * VALOR_POR_KM + ADICIONAL_PRIORIDADE;
    }

    @Override
    public int calcularPrazo() {
        return 1 + (int) Math.ceil(getDistancia() / 500);
    }
}
