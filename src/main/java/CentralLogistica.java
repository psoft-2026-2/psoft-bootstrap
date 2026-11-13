import java.util.*;

public class CentralLogistica {
    private static CentralLogistica instance;
    private List<Pedido> pedidos;

    private CentralLogistica() {
        this.pedidos = new ArrayList<>();
    }

    public static CentralLogistica getInstance() {
        if (instance == null) {
            instance = new CentralLogistica();
        }
        return instance;
    }

    public int fazerPedido(String cliente, String origem, String destino, float peso, float dist, ModalidadeStrategy mod) {
        Pedido pedido = new Pedido(cliente, origem, destino, peso, dist, mod);
        pedidos.add(pedido);
        return pedidos.size() - 1;
    }

    public boolean alterarModalidadePedido(int id, ModalidadeStrategy modalidade) {
        Pedido pedido = pedidos.get(id);
        if (modalidade == null || pedido.isDespachado()) return false;

        pedido.alterarModalidade(modalidade);
        return true;
    }

    public boolean despacharPedido(int id) {
        Pedido pedido = pedidos.get(id);
        if (pedido.isDespachado() || pedido.getModalidadeEntrega() == null) return false;

        pedido.despachar();
        return true;
    }

    public float calcularPrazoPedido(int id) {
        return pedidos.get(id).calcularPrazo();
    }

    public float calcularCustoPedido(int id) {
        return pedidos.get(id).calcularCusto();
    }
}