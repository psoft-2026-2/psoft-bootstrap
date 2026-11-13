public class EntregaConvencional implements EntregaStrategy {
    private double tarifaFixa;
    private double valorPorKm;
    private int prazo;

    public EntregaConvencional(double tarifaFixa, double valorPorKm, int prazo) {
        if (!Double.isFinite(tarifaFixa) || tarifaFixa < 0) throw new IllegalArgumentException("Tarifa fixa deve ser nao negativa e finita");
        if (!Double.isFinite(valorPorKm) || valorPorKm < 0) throw new IllegalArgumentException("Valor por km deve ser nao negativo e finito");
        if (prazo <= 0) throw new IllegalArgumentException("Prazo deve ser positivo");
        
        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
        this.prazo = prazo;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return tarifaFixa + valorPorKm * pedido.getDistancia();
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return prazo;
    }

    @Override
    public String getNome() {
        return "Convencional";
    }
}
