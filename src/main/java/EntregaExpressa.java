public class EntregaExpressa implements ModalidadeStrategy {
    private double tarifa;
    private double valorPorKm;
    private double custoAdicional;
    private int prazoEstimado;

    public EntregaExpressa(double tarifa, double valorPorKm, double custoAdicional, int prazoEstimado) {
        if (tarifa < 0) throw new IllegalArgumentException("Tarifa deve ser positiva");
        if (valorPorKm < 0) throw new IllegalArgumentException("Valor por KM deve ser positivo");
        if (prazoEstimado < 0) throw new IllegalArgumentException("Prazo deve ser positivo");
        if (custoAdicional < 0) throw new IllegalArgumentException("Custo adicional deve ser positivo");
        
        this.tarifa = tarifa;
        this.valorPorKm = valorPorKm;
        this.custoAdicional = custoAdicional;
        this.prazoEstimado = prazoEstimado;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return this.tarifa + valorPorKm * pedido.getDistanciaEstimada() + custoAdicional;
    }

    @Override
    public int prazoEstimado(Pedido pedido) {
        return this.prazoEstimado;
    }
}