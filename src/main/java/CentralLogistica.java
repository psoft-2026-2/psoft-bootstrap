import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//Temos que fazer um singleton para essa classe
public class CentralLogistica {

    private final Map<Integer, Pedido> pedidos = new LinkedHashMap<>();
    private int proximoId = 1;

    private CentralLogistica() {
    }

    private static class Holder {
        private static final CentralLogistica INSTANCIA = new CentralLogistica();
    }

    public static CentralLogistica getInstance() {
        return Holder.INSTANCIA;
    }

    public synchronized Pedido registrarPedido(Cliente cliente, Endereco origem, Endereco destino,
                                               double peso, double distanciaKm) {
        Pedido pedido = new Pedido(proximoId, cliente, origem, destino, peso, distanciaKm);
        pedidos.put(proximoId, pedido);
        proximoId++;
        return pedido;
    }

    public synchronized void selecionarModalidade(int idPedido, ModalidadeEntrega modalidade) {
        buscar(idPedido).selecionarModalidade(modalidade);
    }

    public synchronized BigDecimal calcularCusto(int idPedido) {
        return buscar(idPedido).calcularCusto();
    }

    public synchronized int calcularPrazo(int idPedido) {
        return buscar(idPedido).calcularPrazo();
    }

    public synchronized void despachar(int idPedido) {
        buscar(idPedido).despachar();
    }

    public synchronized String acompanhar(int idPedido) {
        return buscar(idPedido).toString();
    }

    public synchronized List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos.values());
    }

    private Pedido buscar(int idPedido) {
        Pedido pedido = pedidos.get(idPedido);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido com ID " + idPedido + " não encontrado.");
        }
        return pedido;
    }
}
