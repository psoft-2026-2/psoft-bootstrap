import java.util.*;

public class Central {

    private static Central instancia;
    private Set<Cliente> clientes;
    private List<Pedido> pedidos;
    private int proximoId = 1;

    private Central() {
        this.clientes = new HashSet<>();
        this.pedidos = new ArrayList<>();
    }

    public static Central getInstancia() {
        if (instancia == null) {
            instancia = new Central();
        }
        return instancia;
    }

    public Pedido criaPedido(String cpfCliente, String origem, String destino, double peso, double distancia, ModalidadeStrategy modalidade) {
        Pedido pedido = new Pedido(buscaCliente(cpfCliente), proximoId, origem, destino, peso, distancia, modalidade);
        pedidos.add(pedido);
        proximoId++;
        return pedido;
    }

    public boolean removePedido(int id) {
        for (int i = 0; i < this.pedidos.size(); i++) {
            if (this.pedidos.get(i).getId() == id) {
                this.pedidos.remove(i);
                return true;
            }
        }
        return false;
    }

    public Pedido buscaPedido(int id) {
        for (Pedido pedido : this.pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    public boolean alterarModalidade(int id, ModalidadeStrategy modalidade) {
        Pedido pedido = buscaPedido(id);
        if (modalidade == null || pedido == null || pedido.isDespachado()) return false;
        pedido.setModalidadeEntrega(modalidade);
        return true;
    }

    public boolean despacharPedido(int id) {
        Pedido pedido = buscaPedido(id);
        if (pedido == null || pedido.isDespachado() || pedido.getModalidadeEntrega() == null) {
            return false;
        }
        pedido.despachar();
        return true;
    }

    public List<Pedido> getPedidos() {
        return List.copyOf(pedidos);
    }

    public void addCliente(String cpf) {
        addCliente(cpf, null, null);
    }

    public void addCliente(String cpf, String nome, String telefone) {
        if (cpf == null || cpf.isBlank()) throw new IllegalArgumentException("CPF não pode ser vazio");
        if (buscaCliente(cpf) == null) {
            clientes.add(new Cliente(cpf, nome, telefone));
        }
    }

    public boolean removeCliente(String cpf) {
        return clientes.remove(buscaCliente(cpf));
    }

    public Cliente buscaCliente(String cpf) {
        for (Cliente cliente : this.clientes) {
            if (cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }

}
