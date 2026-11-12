package logistica;

//Strategy
public interface Entrega {

    String getNome();

    double calcularCusto(double pesoKg, double distanciaKm);

    int calcularPrazoEmDias(double distanciaKm);
}
