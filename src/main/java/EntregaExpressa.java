import java.time.LocalDate;

public class EntregaExpressa implements EstrategiaEntrega {
    private static final double KM_POR_DIA = 250.0;

    public double CalculaCusto(double distanciaKm) {
        return distanciaKm * 1.70;
    }

    public LocalDate CalculaPrazo(double distanciaKM, LocalDate dataDoPedido) {
        int dias = (int) Math.ceil(distanciaKM / KM_POR_DIA);

        return dataDoPedido.plusDays(dias);
    }
}