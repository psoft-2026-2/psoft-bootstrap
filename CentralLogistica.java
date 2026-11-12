import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CentralLogistica {
    private static CentralLogistica instancia;

    private final List<Pedido> pedidos = new ArrayList<>();
    private int proximoId = 1;

    private CentralLogistica() {}

    public static synchronized CentralLogistica getInstancia() {
        if (instancia == null) {
            instancia = new CentralLogistica();
        }
        return instancia;
    }

    public Pedido registrarPedido(Cliente cliente, Endereco origem, Endereco destino,
                                  double pesoKg, double distanciaKm) {
        Pedido pedido = new Pedido(proximoId++, cliente, origem, destino, pesoKg, distanciaKm);
        pedidos.add(pedido);
        return pedido;
    }

    public void selecionarModalidade(Pedido pedido, ModalidadeEntrega modalidade) {
        pedido.definirModalidade(modalidade);
    }

    public void solicitarEntrega(Pedido pedido) {
        pedido.solicitarEntrega();
    }

    public void alterarModalidade(Pedido pedido, ModalidadeEntrega nova) {
        pedido.definirModalidade(nova);
    }

    public void despachar(Pedido pedido) {
        pedido.despachar();
    }

    public List<Pedido> listarPedidos() {
        return Collections.unmodifiableList(pedidos);
    }
}