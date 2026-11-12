public class EntregaConvencional implements ModalidadeEntrega {
    private double tarifaFixa;
    private double valorPorKm;

    public EntregaConvencional() {
        this.tarifaFixa = 15.0;
        this.valorPorKm = 0.50;
    }

    public EntregaConvencional(double tarifaFixa, double valorPorKm) {
        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return tarifaFixa + (pedido.getDistanciaEstimada() * valorPorKm);
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return 3 + (int) Math.ceil(pedido.getDistanciaEstimada() / 100.0);
    }
}