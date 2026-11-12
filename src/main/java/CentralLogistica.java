import java.util.ArrayList;
import java.util.List;

public class CentralLogistica {
    private static CentralLogistica instancia;
    private List<Pedido> pedidos;

    private CentralLogistica() {
        this.pedidos = new ArrayList<>();
    }

    public static synchronized CentralLogistica getInstancia() {
        if (instancia == null) {
            instancia = new CentralLogistica();
        }
        return instancia;
    }

    public void registrarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void selecionarModalidade(Pedido pedido, ModalidadeEntrega novaModalidade) {
        pedido.alterarModalidade(novaModalidade);
    }

    public String solicitarEntrega(Pedido pedido) {
        double custo = pedido.calcularCusto();
        int prazo = pedido.calcularPrazo();
        return String.format(
            "Pedido de %s (%s -> %s) | Custo: R$ %.2f | Prazo estimado: %d dias | Despachado: %s",
            pedido.getCliente(),
            pedido.getEnderecoOrigem(),
            pedido.getEnderecoDestino(),
            custo,
            prazo,
            pedido.isDespachado() ? "Sim" : "Não"
        );
    }

    public void despacharPedido(Pedido pedido) {
        pedido.despachar();
    }

    public List<Pedido> getPedidos() {
        return new ArrayList<>(this.pedidos);
    }
}
