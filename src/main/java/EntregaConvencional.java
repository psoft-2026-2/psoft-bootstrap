
public class EntregaConvencional implements ModalidadeEntrega {

    @Override
    public double calcularCusto(Pedido pedido) {
        double tarifaFixa = 10.0;
        double valorPorKm = 0.5;

        return tarifaFixa + (pedido.getDistancia() * valorPorKm);
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return 5;
    }
}
