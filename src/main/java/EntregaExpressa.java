public class EntregaExpressa implements EntregaStrategy {
    private double tarifaFixa;
    private double valorPorKm;
    private double taxaPrioridade;
    private int prazo;

    public EntregaExpressa(double tarifaFixa, double valorPorKm, double taxaPrioridade, int prazo) {
        if (!Double.isFinite(tarifaFixa) || tarifaFixa < 0) throw new IllegalArgumentException("Tarifa fixa deve ser nao negativa e finita");
        if (!Double.isFinite(valorPorKm) || valorPorKm < 0) throw new IllegalArgumentException("Valor por km deve ser nao negativo e finito");
        if (!Double.isFinite(taxaPrioridade) || taxaPrioridade < 0) throw new IllegalArgumentException("Taxa de prioridade deve ser nao negativa e finita");
        if (prazo <= 0) throw new IllegalArgumentException("Prazo deve ser positivo");
        
        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
        this.taxaPrioridade = taxaPrioridade;
        this.prazo = prazo;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return tarifaFixa + valorPorKm * pedido.getDistancia() + taxaPrioridade;
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return prazo;
    }

    @Override
    public String getNome() {
        return "Expressa";
    }
}
