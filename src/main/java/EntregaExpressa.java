public class EntregaExpressa implements EntregaIF {
    private double tarifaFixa;
    private double valorPorKm;
    private double taxaPrioridade;
    private int prazo;

    public EntregaExpressa(double tarifaFixa, double valorPorKm, double taxaPrioridade, int prazo) {   
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
    public double calcularPrazoEntrega(Pedido pedido) {
        return prazo;
    }

}