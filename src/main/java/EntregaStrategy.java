public interface EntregaStrategy {

    double calcularCusto(Pedido pedido);

    int calcularPrazo(Pedido pedido);

    String getNome();
}
