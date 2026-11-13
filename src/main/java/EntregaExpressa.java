public class EntregaExpressa implements Entrega {

    private Empresa empresa;
    private Pedido pedido;
    private double distanciaEco;

    public EntregaExpressa() {
        this(Empresa.getEmpresa(), 100.0);
    }

    public EntregaExpressa(Empresa empresa, double distanciaEco) {
        this.empresa = empresa;
        this.distanciaEco = distanciaEco;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        this.pedido = pedido;
        return this.pedido.getPeso() * 2.5
                + this.pedido.getDistancia() * 0.7;
    }

    @Override
    public double calcularTempo(Pedido pedido) {
        this.pedido = pedido;
        return this.pedido.getDistancia() / distanciaEco;
    }
}
