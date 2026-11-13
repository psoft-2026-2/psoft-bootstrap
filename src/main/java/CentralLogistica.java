import java.util.ArrayList;
import java.util.List;

public class CentralLogistica {

    private static CentralLogistica instancia;

    private List<Pedido> pedidos;
    private int proximoId;

    private CentralLogistica() {
        this.pedidos = new ArrayList<>();
        this.proximoId = 1;
    }

    public static CentralLogistica getInstancia() {
        if (instancia == null) {
            instancia = new CentralLogistica();
        }
        return instancia;
    }

    public Pedido registrarPedido(Cliente cliente, Endereco origem, Endereco destino,
                                  double peso, double distancia, ModalidadeEntrega modalidade) {
        Pedido pedido = new Pedido(proximoId, cliente, origem, destino, peso, distancia, modalidade);
        pedidos.add(pedido);
        proximoId++;
        return pedido;
    }

    public Pedido buscarPedido(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        throw new IllegalArgumentException("Pedido #" + id + " nao encontrado.");
    }

    public void alterarModalidade(int idPedido, ModalidadeEntrega novaModalidade) {
        Pedido pedido = buscarPedido(idPedido);
        pedido.alterarModalidade(novaModalidade);
    }

    public void despacharPedido(int idPedido) {
        Pedido pedido = buscarPedido(idPedido);
        pedido.despachar();
    }

    public double calcularCusto(int idPedido) {
        return buscarPedido(idPedido).calcularCusto();
    }

    public int calcularPrazo(int idPedido) {
        return buscarPedido(idPedido).calcularPrazo();
    }

    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos);
    }

    public List<Pedido> listarPedidosNaoDespachados() {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (!pedido.isDespachado()) {
                resultado.add(pedido);
            }
        }
        return resultado;
    }
}
