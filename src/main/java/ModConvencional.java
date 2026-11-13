public class ModConvencional implements ModalidadeEntrega {

    private double tarifaFixa;
    private double valorPorKm;

    public ModConvencional(double tarifaFixa, double valorPorKm) {
        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return tarifaFixa + valorPorKm * pedido.getDistanciaEstimada();
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return 2 + (int) Math.ceil(pedido.getDistanciaEstimada() / 200);
    }

    @Override
    public String getNome() {
        return "Convencional";
    }

    public double getTarifaFixa() {
        return tarifaFixa;
    }

    public double getValorPorKm() {
        return valorPorKm;
    }
}
