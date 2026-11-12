import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Pedido> pedidos;
    private List<Cliente> clientes;

    public Empresa() {
        this.pedidos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void cadastrarCliente(String cpf, String nome) {
        clientes.add(new Cliente(cpf, nome, "Endereço não informado"));
    }

    public void removerCliente(String cpf) {
        clientes.removeIf(c -> c.getCpf().equals(cpf));
    }

    public Cliente buscarCliente(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public List<Cliente> listarCliente() {
        return this.clientes;
    }

    public Integer criarPedido(Cliente cliente, String origem, String destino, Double peso, Double distancia, Entrega modalidade) {
        Integer novoId = pedidos.size() + 1; 
        Pedido novoPedido = new Pedido(
            cliente.getCpf(), 
            cliente.getNome(), 
            origem, 
            destino, 
            distancia, 
            peso, 
            novoId, 
            modalidade
        );
        pedidos.add(novoPedido);
        return novoId;
    }

    public Pedido lerPedido(Integer id) {
        return pedidos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void atualizarStatusPedido(Integer id, StatusEnum novoStatus) {
        Pedido pedido = lerPedido(id);
        if (pedido != null) {
            pedido.setStatus(novoStatus);
        }
    }

    public void removerPedido(Integer id) {
        pedidos.removeIf(p -> p.getId().equals(id));
    }

    public List<Pedido> listarPedidos() {
        return this.pedidos;
    }
}