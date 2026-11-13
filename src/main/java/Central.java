import java.util.ArrayList;
import java.util.List;

public class Central {

    private static Central instancia;
    private List<Pedido> pedidos;

    private Central() {
        pedidos = new ArrayList<>();
    }

    public static Central getInstancia() {
        if (instancia == null) {
            instancia = new Central();
        }

        return instancia;
    }

    public void gerenciar(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
