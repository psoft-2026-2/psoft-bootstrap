import java.time.LocalDate;

public class EntregaConvencional implements EstrategiaEntrega {
    private static final double TAXA_FIXA = 25.00;
    private static final double KM_POR_DIA = 140.0;

    public double CalculaCusto(double distanciaKm) {
        return distanciaKm * 1.20 + TAXA_FIXA;
    }

    public LocalDate CalculaPrazo(double distanciaKM, LocalDate dataDoPedido) {
        int dias = (int) Math.ceil(distanciaKM / KM_POR_DIA);

        return dataDoPedido.plusDays(dias);
    }
}