public class EntregaEconomica implements ModalidadeEntrega {
    private double tarifaReduzida;
    private double valorPorKm;

    public EntregaEconomica() {
        this.tarifaReduzida = 8.0;
        this.valorPorKm = 0.30;
    }

    public EntregaEconomica(double tarifaReduzida, double valorPorKm) {
        this.tarifaReduzida = tarifaReduzida;
        this.valorPorKm = valorPorKm;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return tarifaReduzida + (pedido.getDistanciaEstimada() * valorPorKm);
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return 7 + (int) Math.ceil(pedido.getDistanciaEstimada() / 80.0);
    }
}