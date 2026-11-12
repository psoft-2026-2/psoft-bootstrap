public class EntregaExpresso implements Entrega {
    @Override
    public float getTempo(float distancia) {
        return distancia / 90f;
    }

    @Override
    public float getCusto(float distancia) {
        return distancia * 2.0f;
    }
}