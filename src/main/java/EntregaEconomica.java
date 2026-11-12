import java.time.LocalDate;

public class EntregaEconomica implements EstrategiaEntrega {
    private static final double KM_POR_DIA = 70.0;
    
    public double CalculaCusto(double distanciaKm) {
        return distanciaKm * 0.85;
    }

    public LocalDate CalculaPrazo(double distanciaKM, LocalDate dataDoPedido) {
        int dias = (int) Math.ceil(distanciaKM / KM_POR_DIA);

        return dataDoPedido.plusDays(dias);
    }
}