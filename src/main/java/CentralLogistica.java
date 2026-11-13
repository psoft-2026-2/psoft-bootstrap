import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CentralLogistica {
    private static CentralLogistica instance;
    private final Map<Integer, Cliente> clientes = new HashMap<>();
    private final Map<Integer, Pedido> pedidos = new HashMap<>();

    private CentralLogistica() {}

    public static synchronized CentralLogistica getInstance() {
        if (instance == null) instance = new CentralLogistica();
        return instance;
    }

    public void cadastrarCliente(Cliente cliente) {
        if (clientes.putIfAbsent(cliente.getId(), cliente) != null)
            throw new IllegalArgumentException("Já existe cliente com id " + cliente.getId());
    }

    public Cliente buscarCliente(int idCliente) {
        Cliente c = clientes.get(idCliente);
        if (c == null) throw new IllegalArgumentException("Cliente " + idCliente + " não existe.");
        return c;
    }

    public void registrarPedido(int idPedido, int idCliente, String origem, String destino, double peso, double distanciaKm) {
        if (pedidos.containsKey(idPedido))
            throw new IllegalArgumentException("Já existe pedido com id " + idPedido);
        Cliente cliente = buscarCliente(idCliente);
        pedidos.put(idPedido, new Pedido(idPedido, cliente, origem, destino, peso, distanciaKm));
    }

    public void selecionarModalidade(int idPedido, ModalidadeEntrega modalidade) {
        buscarPedido(idPedido).setModalidade(modalidade);
    }

    public void alterarModalidade(int idPedido, ModalidadeEntrega nova) {
        selecionarModalidade(idPedido, nova);
    }

    public double calcularCusto(int idPedido) { 
        return buscarPedido(idPedido).calcularCusto(); 
    }

    public int calcularPrazo(int idPedido) { 
        return buscarPedido(idPedido).calcularPrazo(); 
    }

    public void despachar(int idPedido) { 
        buscarPedido(idPedido).despachar(); 
    }

    public Pedido consultarPedido(int idPedido) { 
        return buscarPedido(idPedido); 
    }

    public Collection<Pedido> acompanharOperacoes() {
        return Collections.unmodifiableCollection(pedidos.values());
    }

    private Pedido buscarPedido(int id) {
        Pedido p = pedidos.get(id);
        if (p == null) throw new IllegalArgumentException("Pedido " + id + " não existe.");
        return p;
    }
}