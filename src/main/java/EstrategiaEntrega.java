public interface EstrategiaEntrega {
    double calcularCusto(Pedido pedido);

    int calcularPrazo(Pedido pedido);
}
