public class EntregaEconomica implements Entrega {
    @Override
    public float getTempo(float distancia) {
        return distancia / 30f;
    }

    @Override
    public float getCusto(float distancia) {
        return distancia * 0.5f;
    }
}