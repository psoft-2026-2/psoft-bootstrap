public interface ModalidadeEntrega {

    double calcularCusto(Pedido pedido);

    double calcularPrazoEntrega(Pedido pedido);
}
