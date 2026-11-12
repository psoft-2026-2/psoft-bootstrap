public class EntregaEconomica implements Entrega {

    private double tarifaPorKm;
    private double percentualDesconto;
    private String prazo;

    public EntregaEconomica(double tarifaPorKm, double percentualDesconto, String prazo) {
        this.tarifaPorKm = tarifaPorKm;
        this.percentualDesconto = percentualDesconto;
        this.prazo = prazo;
    }

    @Override
    public double calcularCustoEntrega(double distancia) {
        double custo = tarifaPorKm * distancia;

        return custo - (custo * percentualDesconto / 100);
    }

    @Override
    public String calcularPrazoEntrega() {
        return prazo;
    }
}