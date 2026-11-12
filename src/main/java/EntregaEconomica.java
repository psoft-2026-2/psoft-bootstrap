public class EntregaEconomica implements ModalidadeEntrega {

    @Override
    public double calcularCusto(Pedido pedido) {
        double tarifaFixa = 5.0;
        double valorPorKm = 0.3;

        return tarifaFixa + (pedido.getDistancia() * valorPorKm);
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return 10;
    }
}