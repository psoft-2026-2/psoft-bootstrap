public class EntregaConvencional implements ModalidadeStrategy {
    private double tarifa;
    private double valorPorKm;
    private int prazoEstimado;

    public EntregaConvencional(double tarifa, double valorPorKm, int prazoEstimado) {
        if (tarifa < 0) throw new IllegalArgumentException("Tarifa deve ser positiva");
        if (valorPorKm < 0) throw new IllegalArgumentException("Valor por KM deve ser positivo");
        if (prazoEstimado < 0) throw new IllegalArgumentException("Prazo deve ser positivo");
        
        this.tarifa = tarifa;
        this.valorPorKm = valorPorKm;
        this.prazoEstimado = prazoEstimado;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return this.tarifa + this.valorPorKm * pedido.getDistanciaEstimada();
    }

    @Override
    public int prazoEstimado(Pedido pedido) {
        return this.prazoEstimado;
    }
}