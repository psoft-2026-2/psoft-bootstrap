package br.ufcg.psoft.atv5;

public class EntregaExpressa implements ModalidadeEntrega {
    private static final double TARIFA_FIXA = 10.0;
    private static final double VALOR_POR_KM = 1.5;
    private static final double ADICIONAL_PRIORIDADE = 25.0;
    private static final double PRAZO_BASE_DIAS = 1.0;
    private static final double KM_POR_DIA = 800.0;

    @Override
    public double calcularCusto(Pedido pedido) {
        return TARIFA_FIXA + VALOR_POR_KM * pedido.getDistancia() + ADICIONAL_PRIORIDADE;
    }

    @Override
    public double calcularPrazo(Pedido pedido) {
        return PRAZO_BASE_DIAS + pedido.getDistancia() / KM_POR_DIA;
    }
}
