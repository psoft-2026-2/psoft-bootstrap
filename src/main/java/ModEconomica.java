public class ModEconomica implements ModalidadeEntrega {

    private double tarifaFixa;
    private double valorPorKm;
    private double fatorDesconto;
    private int diasExtras;

    public ModEconomica(double tarifaFixa, double valorPorKm, double fatorDesconto, int diasExtras) {
        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
        this.fatorDesconto = fatorDesconto;
        this.diasExtras = diasExtras;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        double base = tarifaFixa + valorPorKm * pedido.getDistanciaEstimada();
        return base * (1 - fatorDesconto);
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return 2 + (int) Math.ceil(pedido.getDistanciaEstimada() / 200) + diasExtras;
    }

    @Override
    public String getNome() {
        return "Econômica";
    }

    public double getFatorDesconto() {
        return fatorDesconto;
    }
}
