public class Economica implements Entrega {
    private static final Double DESCONTO = 5.0;
    private static final Double VALOR_KM = 1.0;

    @Override
    public Double calcularCusto(Double distancia, Double peso) {
        Double custo = (distancia * VALOR_KM) + (peso * 0.3) - DESCONTO;

        if (custo < 0) {
            custo = 0.0; 
        }
        
        return custo;
    }

    @Override
    public Integer estimarPrazo(Double distancia) {
        return (int) (distancia / 30) + 7; 
    }
}