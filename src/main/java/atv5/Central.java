package atv5;

import java.util.ArrayList;
import java.util.List;

public class Central {

    private static Central central;
    private List<Cliente> clientes;
    private List<Pedido> pedidos;

    private Central() {
        this.clientes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public static Central getCentral() {
        if (central == null) {
            central = new Central();
        }
        return central;
    }

    public void adicionarCliente(Cliente cliente) {
        if (cliente != null) {
            clientes.add(cliente);
        }
    }

    public Cliente getCliente(int idCliente) {
        for (Cliente c : clientes) {
            if (c.getIdCliente() == idCliente) {
                return c;
            }
        }
        return null;
    }

    public void registrarPedido(Pedido pedido) {
        if (pedido != null) {
            pedidos.add(pedido);
        }
    }

    public Pedido getPedido(int idPedido) {
        for (Pedido p : pedidos) {
            if (p.getIdPedido() == idPedido) {
                return p;
            }
        }
        return null;
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }

    // esqueci de colocar na modelagem
    public List<Pedido> getPedidos() {
        return new ArrayList<>(pedidos);
    }
}
