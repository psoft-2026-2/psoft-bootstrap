public interface ModalidadeStrategy {
    double calcularCusto(Pedido pedido);

    int prazoEstimado(Pedido pedido);
}
