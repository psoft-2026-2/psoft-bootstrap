public class EntregaEconomica implements EntregaIF {
    private double tarifaFixa;
    private double valorPorKm;
    private double desconto;
    private int prazo;

    public EntregaEconomica(double tarifaFixa, double valorPorKm, double desconto, int prazo) {
        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
        this.desconto = desconto;
        this.prazo = prazo;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        double custoInicial = tarifaFixa + valorPorKm * pedido.getDistancia();
        return custoInicial - (custoInicial * desconto);
    }

    @Override
    public double calcularPrazoEntrega(Pedido pedido) {
        return prazo;
    }

}
