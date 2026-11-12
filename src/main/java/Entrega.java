public interface Entrega {
    Double calcularCusto(Double distancia, Double peso);
    Integer estimarPrazo(Double distancia);
}