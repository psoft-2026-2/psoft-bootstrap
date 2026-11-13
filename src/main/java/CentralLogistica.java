import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CentralLogistica {
    private static CentralLogistica instancia;
    private final List<Pedido> pedidos = new ArrayList<>();

    private CentralLogistica() {}

    public static synchronized CentralLogistica getInstance() {
        if (instancia == null) {
            instancia = new CentralLogistica();
        }
        return instancia;
    }

    public void registrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void selecionarModalidade(Pedido pedido, ModalidadeEntrega modalidade) {
        pedido.alterarModalidade(modalidade);
    }

    public void solicitarEntrega(Pedido pedido) {
        System.out.printf("Pedido %d | %s | custo: R$ %.2f | prazo: %d dias%n",
                pedido.getId(),
                pedido.getModalidade().getNome(),
                pedido.calcularCusto(),
                pedido.calcularPrazoDias());
    }

    public void despachar(Pedido pedido) {
        pedido.despachar();
        System.out.println("Pedido " + pedido.getId() + " despachado.");
    }

    public List<Pedido> getPedidos() {
        return Collections.unmodifiableList(pedidos);
    }
}
