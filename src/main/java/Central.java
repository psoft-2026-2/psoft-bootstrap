import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Central {

    private static final Central instancia = new Central();

    private List<Pedido> pedidos;

    private Central() {
        pedidos = new ArrayList<>();
    }

    public static Central getInstancia() {
        return instancia;
    }

    public void registrarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo.");
        }

        pedidos.add(pedido);
    }

    public double calcularCusto(Pedido pedido) {
        verificarPedido(pedido);

        return pedido.calcularCustoEntrega();
    }

    public String calcularPrazo(Pedido pedido) {
        verificarPedido(pedido);

        return pedido.calcularPrazoEntrega();
    }

    public void alterarEntrega(Pedido pedido, Entrega entrega) {
        verificarPedido(pedido);

        pedido.alterarEntrega(entrega);
    }

    public void despacharPedido(Pedido pedido) {
        verificarPedido(pedido);

        pedido.despachar();
    }

    private void verificarPedido(Pedido pedido) {
        if (pedido == null || !pedidos.contains(pedido)) {
            throw new IllegalArgumentException(
                "Pedido não encontrado na central."
            );
        }
    }

    public List<Pedido> getPedidos() {
        return Collections.unmodifiableList(pedidos);
    }
}