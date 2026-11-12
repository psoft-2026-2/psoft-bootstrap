public class EntregaExpressa implements ModalidadeEntrega {
    private double tarifaFixa;
    private double valorPorKm;
    private double custoAdicionalPrioridade;

    public EntregaExpressa() {
        this.tarifaFixa = 15.0;
        this.valorPorKm = 0.75;
        this.custoAdicionalPrioridade = 25.0;
    }

    public EntregaExpressa(double tarifaFixa, double valorPorKm, double custoAdicionalPrioridade) {
        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
        this.custoAdicionalPrioridade = custoAdicionalPrioridade;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return tarifaFixa + (pedido.getDistanciaEstimada() * valorPorKm) + custoAdicionalPrioridade;
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return 1 + (int) Math.ceil(pedido.getDistanciaEstimada() / 250.0);
    }
}