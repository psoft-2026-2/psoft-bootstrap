public interface ModalidadeStrategy {

    float calcularCusto(Pedido pedido);

    float calcularPrazo(Pedido pedido);
}