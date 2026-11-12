package logistica;

public class EntregaExpressa implements Entrega {

    private double tarifaFixa;
    private double valorPorKm;
    private double adicionalPrioridade;
    private double kmPorDia = 300.0;

    public EntregaExpressa() {
        this(10.00, 1.50, 20.00);
    }

    public EntregaExpressa(double tarifaFixa, double valorPorKm, double adicionalPrioridade) {
        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
        this.adicionalPrioridade = adicionalPrioridade;
    }

    @Override
    public String getNome() {
        return "Expressa";
    }

    @Override
    public double calcularCusto(double pesoKg, double distanciaKm) {
        return tarifaFixa + valorPorKm * distanciaKm + adicionalPrioridade;
    }

    @Override
    public int calcularPrazoEmDias(double distanciaKm) {
        return (int) (distanciaKm / kmPorDia) + 1;
    }
}
