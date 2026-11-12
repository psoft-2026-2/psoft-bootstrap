public class EntregaExpressa implements Entrega {

    private double tarifaPorKm;
    private double custoAdicional;
    private String prazo;

    public EntregaExpressa(double tarifaPorKm, double custoAdicional, String prazo) {
        this.tarifaPorKm = tarifaPorKm;
        this.custoAdicional = custoAdicional;
        this.prazo = prazo;
    }

    @Override
    public double calcularCustoEntrega(double distancia) {
        return (tarifaPorKm * distancia) + custoAdicional;
    }

    @Override
    public String calcularPrazoEntrega() {
        return prazo;
    }
}