import java.util.ArrayList;
import java.util.List;

public class CentralLogistica {
    private List<Pedido> pedidos;
    private ModalidadeEntrega modalidade = new EntregaConvencional();
    private static CentralLogistica central;

    private CentralLogistica() {
        this.pedidos = new ArrayList<>();
        this.modalidade = new EntregaConvencional();
    }

    public static CentralLogistica getInstance() {
        if (central == null) {
            central = new CentralLogistica();
        }
        return central;
    }

    public void addPedido(String cpfCliente, String enderecoOrigem, String enderecoDestino, float peso, float dist) {
        int numPedido = pedidos.size();
        pedidos.add(new Pedido(numPedido, cpfCliente, enderecoOrigem, enderecoDestino, dist, peso));
    }

    public Pedido getPedido(int numPedido) {
        return pedidos.get(numPedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public float calcularEntrega(Pedido pedido) {
        return modalidade.calcularValorEntrega(pedido);
    }

    public void setModalidade(ModalidadeEntrega modalidade) {
        this.modalidade = modalidade;
    }
}
