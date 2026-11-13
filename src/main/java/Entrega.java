public abstract class Entrega implements EntregaI {

    private float distancia;
    private float peso;

    public Entrega(float distancia, float peso) {
        this.distancia = distancia;
        this.peso = peso;
    }

    public float getDistancia() {
        return distancia;
    }

    public float getPeso() {
        return peso;
    }

    @Override
    public abstract float calcularPreco();

    @Override
    public abstract int calcularPrazo();
}
