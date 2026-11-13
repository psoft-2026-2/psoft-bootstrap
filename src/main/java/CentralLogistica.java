import java.util.ArrayList;
import java.util.List;

public class CentralLogistica {

    private static CentralLogistica central;

    private List<Pedido> pedidos;

    private CentralLogistica() {
        this.pedidos = new ArrayList<>();
    }

    public static CentralLogistica getInstance() {
        if (central == null) {
            central = new CentralLogistica();
        }
        return central;
    }

    public void despacharPedido(int idPedido) {
        Pedido pedido = pedidos.get(idPedido);
        pedido.setDespachar(true);
    }

    public void cadastrarPedido(String cpfCliente, String nomeItem, String saida, String destino) {
        Pedido novoPedido = new Pedido(cpfCliente, nomeItem, saida, destino);
        pedidos.add(novoPedido);
    }
}
