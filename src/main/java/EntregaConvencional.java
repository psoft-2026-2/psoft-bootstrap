public class EntregaConvencional implements Entrega {

    private double taxaFixa;
    private double tarifaPorKm;
    private String prazo;

    public EntregaConvencional(double taxaFixa, double tarifaPorKm, String prazo) {
        this.taxaFixa = taxaFixa;
        this.tarifaPorKm = tarifaPorKm;
        this.prazo = prazo;
    }

    @Override
    public double calcularCustoEntrega(double distancia) {
        return taxaFixa + (tarifaPorKm * distancia);
    }

    @Override
    public String calcularPrazoEntrega() {
        return prazo;
    }
}