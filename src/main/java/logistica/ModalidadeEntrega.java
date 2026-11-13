package logistica;

public interface ModalidadeEntrega {

    String nome();

    double calcularCusto(Pedido pedido);

    int calcularPrazo(Pedido pedido);
}
