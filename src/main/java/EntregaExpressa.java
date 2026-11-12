
public class EntregaExpressa implements ModalidadeEntrega {

    @Override
    public double calcularCusto(Pedido pedido) {
        double tarifaFixa = 10.0;
        double valorPorKm = 0.5;
        double taxaPrioridade = 20.0;

        return tarifaFixa
                + (pedido.getDistancia() * valorPorKm)
                + taxaPrioridade;
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return 2;
    }
}

