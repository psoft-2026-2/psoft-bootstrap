public class Convencional implements Entrega {
    private static final Double TARIFA_BASE = 10.0;
    private static final Double VALOR_KM = 1.5;

    @Override
    public Double calcularCusto(Double distancia, Double peso) {
        return TARIFA_BASE + (distancia * VALOR_KM) + (peso * 0.5);
    }

    @Override
    public Integer estimarPrazo(Double distancia) {
        return (int) (distancia / 50) + 3; 
    }
}