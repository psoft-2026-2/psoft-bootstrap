import java.util.HashMap;

public class CentralLogistica {

    private static CentralLogistica centralLogistica;
    private HashMap<Long, Pedido> pedidos;

    private CentralLogistica() {
        this.pedidos = new HashMap<>();
    }

    public static CentralLogistica getInstance() {
        if (centralLogistica == null) {
            centralLogistica = new CentralLogistica();
        }
        return centralLogistica;
    }

    public void fazerPedido(Pedido pedido) {
        pedidos.put((long) pedidos.size(), pedido);
    }

    public void enviarPedido(Long id) {
        pedidos.get(id).enviar();
    }

    public void setModalidadeEntrega(Long id, Entrega entrega) {
        pedidos.get(id).setModalidadeEntrega(entrega);
    }

    public Double getCustoEntregaPedido(Long id) {
        return pedidos.get(id).getCustoEntrega();
    }

    public int getPrazoEntregaPedido(Long id) {
        return pedidos.get(id).getPrazoEntrega();
    }
}
