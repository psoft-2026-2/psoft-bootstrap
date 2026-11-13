import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class CentralLogistica {
    private static CentralLogistica instancia;
    private final List<Pedido> pedidos = new ArrayList<>();

    private CentralLogistica() {}

    public static CentralLogistica getInstancia() {
        if (instancia == null) {
            instancia = new CentralLogistica();
        }
        return instancia;
    }

    public void registrarPedido(Pedido pedido) {
        Objects.requireNonNull(pedido);
        if (pedidos.contains(pedido)) {
            throw new IllegalArgumentException("Pedido já registrado");
        }
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return List.copyOf(pedidos);
    }

    public Entrega solicitarEntrega(Pedido pedido) {
        verificarRegistro(pedido);
        return pedido.getEntrega();
    }

    public void alterarModalidade(Pedido pedido, ModalidadeEntrega modalidade) {
        verificarRegistro(pedido);
        pedido.alterarModalidade(modalidade);
    }

    public void despachar(Pedido pedido) {
        verificarRegistro(pedido);
        pedido.despachar();
    }

    private void verificarRegistro(Pedido pedido) {
        if (!pedidos.contains(pedido)) {
            throw new IllegalArgumentException("Pedido não registrado");
        }
    }
}
