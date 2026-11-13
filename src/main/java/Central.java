import java.util.*;

public class Central {
    private static Central instancia;
    private List<Pedido> pedidos;

    private Central() {
        this.pedidos = new ArrayList<>();
    }

    public static Central getInstancia() {
        if (instancia == null) {
            instancia = new Central();
        }
        return instancia;
    }

    public Pedido registrarPedido(String cliente, String origem, String destino, double peso, double distancia, EntregaStrategy modalidade) {
        Pedido pedido = new Pedido(pedidos.size() + 1, cliente, origem, destino, peso, distancia);
        pedido.setModalidadeEntrega(modalidade);
        pedidos.add(pedido);
        return pedido;
    }

    public Pedido recuperarPedido(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public EntregaStrategy selecionarModalidadeEntrega(int id) {
        Pedido pedido = recuperarPedido(id);
        if (pedido == null) {
            return null;
        }
        return pedido.getModalidadeEntrega();
    }

    public boolean alterarModalidadeEntrega(int id, EntregaStrategy modalidade) {
        Pedido pedido = recuperarPedido(id);
        if (modalidade == null || pedido == null || pedido.isDespachado()) {
            return false;
        }
        pedido.setModalidadeEntrega(modalidade);
        return true;
    }

    public String solicitarEntrega(int id) {
        Pedido pedido = recuperarPedido(id);
        if (pedido == null) {
            return "Pedido nao encontrado";
        }
        if (pedido.getModalidadeEntrega() == null) {
            return "Pedido " + id + " sem modalidade de entrega";
        }
        return "Pedido " + id + " | " + pedido.getModalidadeEntrega().getNome()
                + " | custo: R$ " + String.format("%.2f", pedido.calcularCusto())
                + " | prazo: " + pedido.calcularPrazo() + " dias";
    }

    public boolean despacharPedido(int id) {
        Pedido pedido = recuperarPedido(id);
        if (pedido == null || pedido.isDespachado() || pedido.getModalidadeEntrega() == null) {
            return false;
        }
        pedido.despachar();
        return true;
    }

    public List<Pedido> acompanharPedidos() {
        return List.copyOf(pedidos);
    }
}
