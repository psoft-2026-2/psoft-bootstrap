public class ModalidadeExpressa implements ModalidadeEntrega {
    private static final double TARIFA_FIXA = 10.0;
    private final double valorPorKm;
    private final double adicional;

    public ModalidadeExpressa(double valorPorKm, double adicional) {
        this.valorPorKm = valorPorKm;
        this.adicional = adicional;
    }

    @Override
    public double calcularCusto(Pedido p) {
        return TARIFA_FIXA + valorPorKm * p.getDistancia() + adicional;
    }

    @Override
    public int calcularPrazo(Pedido p) { return 1; }

    @Override
    public String getModalidade() { return "Expressa"; }
}
