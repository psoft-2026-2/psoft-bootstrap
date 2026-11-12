import java.time.LocalDate;

public interface EstrategiaEntrega {

    double CalculaCusto(double distanciaKm);

    LocalDate CalculaPrazo(double distanciaKM, LocalDate dataDoPedido);
}