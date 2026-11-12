
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CentralLogistica {

    private static final CentralLogistica INSTANCIA =
            new CentralLogistica();

    private final List<Pedido> pedidos;

    private CentralLogistica() {
        pedidos = new ArrayList<>();
    }

    public static CentralLogistica getInstance() {
        return INSTANCIA;
    }

    public void registrarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException(
                "O pedido nao pode ser nulo."
            );
        }

        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return Collections.unmodifiableList(pedidos);
    }

    public void alterarModalidade(
            Pedido pedido, ModalidadeEntrega modalidade) {
        validarPedidoRegistrado(pedido);
        pedido.setModalidade(modalidade);
    }

    public void despacharPedido(Pedido pedido) {
        validarPedidoRegistrado(pedido);
        pedido.despachar();
    }

    private void validarPedidoRegistrado(Pedido pedido) {
        if (!pedidos.contains(pedido)) {
            throw new IllegalArgumentException(
                "Pedido nao registrado na central."
            );
        }
    }
}

