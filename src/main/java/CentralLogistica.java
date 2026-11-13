import java.util.ArrayList;
import java.util.List;

public class CentralLogistica {
    private static CentralLogistica instance;

    private List<Pedido> pedidos;

    private CentralLogistica() {
        this.pedidos = new ArrayList<>();
    }

    public static CentralLogistica getCentral() {
        if (instance == null) {
            instance = new CentralLogistica();
        }
        return instance;
    }

    public void registrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void selecionarModalidade(Pedido pedido, ModalidadeEntrega modal) {
        pedido.setModalidade(modal);
    }

    public List<Pedido> getPedidos() {
        return new ArrayList<>(pedidos);
    }
}
