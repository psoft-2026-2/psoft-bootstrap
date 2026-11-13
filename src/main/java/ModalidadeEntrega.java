//Strategy
public interface ModalidadeEntrega {

    double calcularCusto(Pedido pedido);

    int calcularPrazo(Pedido pedido);

    String getNome();
}
