public class EntregaConvencional implements EntregaIF {
    private double tarifaFixa;
    private double valorPorKm;
    private int prazo;

    public EntregaConvencional(double tarifaFixa, double valorPorKm, int prazo) {
        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
        this.prazo = prazo;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return tarifaFixa + valorPorKm * pedido.getDistancia();
    }

    @Override
    public double calcularPrazoEntrega(Pedido pedido) {
        return prazo;
    }

}