public class EntregaEconomica implements ModalidadeStrategy {
    private double tarifa;
    private double valorPorKm;
    private double desconto;
    private int prazoEstimado;

    public EntregaEconomica(double tarifa, double valorPorKm, double desconto, int prazoEstimado) {
        if (tarifa < 0) throw new IllegalArgumentException("Tarifa deve ser positiva");
        if (valorPorKm < 0) throw new IllegalArgumentException("Valor por KM deve ser positivo");
        if (prazoEstimado < 0) throw new IllegalArgumentException("Prazo deve ser positivo");
        if (desconto < 0 || desconto > 1) throw new IllegalArgumentException("Desconto deve estar entre [0, 1]");

        this.tarifa = tarifa;
        this.valorPorKm = valorPorKm;
        this.desconto = desconto;
        this.prazoEstimado = prazoEstimado;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return (1 - this.desconto) * (this.tarifa + (this.valorPorKm * pedido.getDistanciaEstimada()));
    }

    @Override
    public int prazoEstimado(Pedido pedido) {
        return this.prazoEstimado;
    }
}