import java.util.HashMap;
import java.util.Map;

public class Central {
    private final Map<String, Pedido> pedidos;
    private final Map<String, Cliente> clientes;
    private ModalidadeEntrega entrega;
    private String idUltimoPedido;

    public Central() {
        pedidos = new HashMap<>();
        clientes = new HashMap<>();
        entrega = new Convencional(10.0f);
    }

    public boolean cadastrarPedido(Cliente cliente, String origem, String destino,
                                   float peso, float distancia, String idPedido) {
        if (cliente == null || idPedido == null || idPedido.trim().isEmpty()
                || pedidos.containsKey(idPedido) || !Float.isFinite(peso) || peso <= 0
                || !Float.isFinite(distancia) || distancia < 0) {
            return false;
        }

        Pedido pedido = new Pedido(cliente, origem, destino, peso, distancia, idPedido);
        pedido.alterarModalidade(entrega);
        pedidos.put(idPedido, pedido);
        idUltimoPedido = idPedido;
        return true;
    }

    public boolean cadastrarCliente(String nome, String cpf, String telefone) {
        if (cpf == null || cpf.trim().isEmpty() || clientes.containsKey(cpf)) {
            return false;
        }

        clientes.put(cpf, new Cliente(nome, cpf, telefone));
        return true;
    }

    public Cliente getCliente(String cpf) {
        return clientes.get(cpf);
    }

    public Pedido getPedido(String idPedido) {
        return pedidos.get(idPedido);
    }

    public boolean alterarModalidade(String idPedido, ModalidadeEntrega modalidade) {
        Pedido pedido = pedidos.get(idPedido);
        return pedido != null && pedido.alterarModalidade(modalidade);
    }

    public boolean realizarEntrega() {
        return realizarEntrega(idUltimoPedido);
    }

    public boolean realizarEntrega(String idPedido) {
        Pedido pedido = pedidos.get(idPedido);
        return pedido != null && pedido.despachar();
    }
}
