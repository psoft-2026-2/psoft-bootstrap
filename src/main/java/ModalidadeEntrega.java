public interface ModalidadeEntrega {
    String getNome();
    double calcularCusto(Pedido pedido);
    int calcularPrazoDias(Pedido pedido);
}
