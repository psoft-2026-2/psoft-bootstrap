public class EntregaConvencional implements Entrega {
    @Override
    public float getTempo(float distancia) {
        return distancia / 60f;
    }

    @Override
    public float getCusto(float distancia) {
        return distancia * 1.0f;
    }
}