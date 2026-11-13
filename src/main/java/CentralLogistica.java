import java.util.ArrayList;

public class CentralLogistica {

    private ArrayList<Pedido> pedidos;
    private static CentralLogistica instance;

    private CentralLogistica() {
        this.pedidos = new ArrayList<>();
    }

    public static CentralLogistica getInstance() {
        if (instance == null) {
            instance = new CentralLogistica();
        }
        return instance;
    }

    public void registrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void setModalidadeEntrega(Pedido pedido, EntregaI entrega) {
        pedido.setModalidadeEntrega(entrega);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
