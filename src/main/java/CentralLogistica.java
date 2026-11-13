import java.util.*;

public class CentralLogistica {

    private static CentralLogistica instance;
    private List<Pedido> pedidos;
    
    private CentralLogistica() {
        this.pedidos = new ArrayList<>();
    }

    public CentralLogistica getInstance() {
        if (instance == null) {
            instance = new CentralLogistica();
        }
        return instance;
    }

    public Pedido registrarPedido(String cliente, String origem, String destino, double peso, Long distancia) {
        Pedido novoPedido = new Pedido(pedidos.size() + 1, cliente, origem, destino, peso, distancia);
        pedidos.add(novoPedido);
        return novoPedido;
    }

    public Pedido recuperarPedido(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void atribuirEntregaAoPedido(Pedido pedido, EntregaIF modalidade) {
        Pedido pedidoAlvo = recuperarPedido(pedido.getId());
        if (pedidoAlvo != null) {
            if (pedidoAlvo.getModalEntrega() == null) {
                pedidoAlvo.setModalidadeEntrega(modalidade);
            }
        }
    }

    public void alterarEntregaDoPedido(Pedido pedido, EntregaIF modalidade) {
        Pedido pedidoAlvo = recuperarPedido(pedido.getId());
        pedidoAlvo.setModalidadeEntrega(modalidade);
    }

    public boolean despacharPedido(int id) {
        Pedido pedido = recuperarPedido(id);
        pedido.despacharPedido();
        return true;
    }

    public List<Pedido> acompanharPedidos() {
        return List.copyOf(pedidos);
    }

}