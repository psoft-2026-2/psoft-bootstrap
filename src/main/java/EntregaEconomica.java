public class EntregaEconomica extends Entrega {

    private static final float VALOR_POR_KM = 0.3f;

    public EntregaEconomica(float distancia, float peso) {
        super(distancia, peso);
    }

    @Override
    public float calcularPreco() {
        return getDistancia() * VALOR_POR_KM;
    }

    @Override
    public int calcularPrazo() {
        return 7 + (int) Math.ceil(getDistancia() / 100);
    }
}
