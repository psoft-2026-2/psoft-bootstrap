public class ModExpressa implements ModalidadeEntrega {

    private double tarifaFixa;
    private double valorPorKm;
    private double adicionalPrioridade;

    public ModExpressa(double tarifaFixa, double valorPorKm, double adicionalPrioridade) {
        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
        this.adicionalPrioridade = adicionalPrioridade;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return tarifaFixa + valorPorKm * pedido.getDistanciaEstimada() + adicionalPrioridade;
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return Math.max(1, (int) Math.ceil(pedido.getDistanciaEstimada() / 500));
    }

    @Override
    public String getNome() {
        return "Expressa";
    }

    public double getAdicionalPrioridade() {
        return adicionalPrioridade;
    }
}
