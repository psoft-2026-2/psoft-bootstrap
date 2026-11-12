public class Expressa implements Entrega {
    private static final Double TAXA_URGENCIA = 25.0;
    private static final Double VALOR_KM = 2.0;

    @Override
    public Double calcularCusto(Double distancia, Double peso) {
        return TAXA_URGENCIA + (distancia * VALOR_KM) + (peso * 0.8);
    }

    @Override
    public Integer estimarPrazo(Double distancia) {
        return (int) (distancia / 100) + 1; 
    }
}