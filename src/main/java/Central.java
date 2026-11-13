import java.util.HashMap;
import java.util.Map;

public class Central {
    private static Central instance;
    private Map<String, Pedido> pedidos = new HashMap<>();

    private Central() {
    }

    public static Central getInstance() {
        if (instance == null) {
            instance = new Central();
        }
        return instance;
    }

    public boolean addPedido(String id, Pedido pedido) {
        return pedidos.putIfAbsent(id, pedido) == null;
    }

    public boolean despachar(String id) {
        Pedido pedido = pedidos.get(id);
        return pedido != null && pedido.despachar();
    }

    public boolean aplicarEntrega(String id, Entrega entrega) {
        Pedido pedido = pedidos.get(id);
        if (pedido == null) {
            return false;
        }
        pedido.setEntrega(entrega);
        return true;
    }

    public Pedido getPedido(String id) {
        return pedidos.get(id);
    }

    public float getTotal(String id) {
        Pedido pedido = pedidos.get(id);
        return pedido == null ? 0f : pedido.getTotal();
    }

    public boolean pagar(String id) {
        return pedidos.containsKey(id);
    }
}