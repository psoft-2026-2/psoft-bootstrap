import java.util.ArrayList;
import java.util.List;

public class CentralLogistica {
    private static CentralLogistica instancia;
    private List<Pedido> pedidos;

    private CentralLogistica() {
        this.pedidos = new ArrayList<>();
    }

    public static synchronized CentralLogistica getInstancia() {
        if (instancia == null) {
            instancia = new CentralLogistica();
        }
        return instancia;
    }

    public void solicitarEntrega(Pedido pedido, EstrategiaEntrega estrategia) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido nao pode ser nulo");
        }
        if (estrategia == null) {
            throw new IllegalArgumentException("Estrategia de entrega nao pode ser nula");
        }
        pedido.setEstrategia(estrategia);
        adicionar(pedido);
        pedido.despachar();
    }

    public void adicionar(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido nao pode ser nulo");
        }
        if (!pedidos.contains(pedido)) {
            pedidos.add(pedido);
        }
    }

    public boolean removerPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido nao pode ser nulo");
        }
        return pedidos.remove(pedido);
    }

    public String toString() {
        return "CentralLogistica{pedidos=" + pedidos + "}";
    }
}
