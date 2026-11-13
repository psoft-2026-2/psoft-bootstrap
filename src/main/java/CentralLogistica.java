import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

//Singleton
public class CentralLogistica {

    private static CentralLogistica instancia;

    private Map<Integer, Pedido> pedidos = new LinkedHashMap<>();

    private CentralLogistica() {
    }

    public static CentralLogistica getInstancia() {
        if (instancia == null) {
            instancia = new CentralLogistica();
        }
        return instancia;
    }

    public void registrarPedido(Pedido pedido) {
        if (pedidos.containsKey(pedido.getId())) {
            throw new IllegalArgumentException("Já existe pedido com id " + pedido.getId());
        }
        pedidos.put(pedido.getId(), pedido);
    }

    public boolean alterarModalidade(int idPedido, ModalidadeEntrega novaModalidade) {
        Pedido pedido = pedidos.get(idPedido);
        if (pedido == null || pedido.isDespachado()) {
            return false;
        }
        pedido.setModalidade(novaModalidade);
        return true;
    }

    public boolean despacharPedido(int idPedido) {
        Pedido pedido = pedidos.get(idPedido);
        if (pedido == null || pedido.isDespachado()) {
            return false;
        }
        pedido.despachar();
        return true;
    }

    public Pedido acompanharPedido(int idPedido) {
        return pedidos.get(idPedido);
    }

    public Collection<Pedido> getPedidos() {
        return pedidos.values();
    }
}
