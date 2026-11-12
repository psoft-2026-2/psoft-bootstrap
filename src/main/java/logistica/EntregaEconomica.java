package logistica;

public class EntregaEconomica implements Entrega {

    private double tarifaFixa;
    private double valorPorKm;
    private double kmPorDia = 50.0;

    public EntregaEconomica() {
        this(5.00, 0.90);
    }

    public EntregaEconomica(double tarifaFixa, double valorPorKm) {
        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
    }

    @Override
    public String getNome() {
        return "Econômica";
    }

    @Override
    public double calcularCusto(double pesoKg, double distanciaKm) {
        return tarifaFixa + valorPorKm * distanciaKm;
    }

    @Override
    public int calcularPrazoEmDias(double distanciaKm) {
        return (int) (distanciaKm / kmPorDia) + 1;
    }
}
