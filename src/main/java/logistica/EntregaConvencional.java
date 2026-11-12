package logistica;

public class EntregaConvencional implements Entrega {

    private double tarifaFixa;
    private double valorPorKm;
    private double kmPorDia = 100.0;

    public EntregaConvencional() {
        this(10.00, 1.50);
    }

    public EntregaConvencional(double tarifaFixa, double valorPorKm) {
        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
    }

    @Override
    public String getNome() {
        return "Convencional";
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
