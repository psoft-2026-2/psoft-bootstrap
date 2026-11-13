import java.util.ArrayList;
import java.util.List;

public class CentralLogistica {

    private static CentralLogistica instancia;

    private List<Pedido> pedidos;
    private List<ModalidadeEntrega> modalidades;

    private CentralLogistica() {
        this.pedidos = new ArrayList<>();
        this.modalidades = new ArrayList<>();
    }

    public static CentralLogistica getInstancia() {
        if (instancia == null) {
            instancia = new CentralLogistica();
        }
        return instancia;
    }

    public void registrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void selecionarModalidadeEntrega(ModalidadeEntrega modalidade, Pedido pedido) {
        pedido.setModalidade(modalidade);
    }

    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos);
    }

    public void criarModalidade(ModalidadeEntrega modalidade) {
        modalidades.add(modalidade);
    }

    public List<ModalidadeEntrega> listarModalidades() {
        return new ArrayList<>(modalidades);
    }

    public void solicitarEntrega(Pedido pedido) {
        if (pedido.getStatus() == StatusPedido.DESPACHADO) {
            throw new IllegalStateException("Pedido já foi despachado.");
        }
        ModalidadeEntrega modalidade = pedido.getModalidade();
        double custo = modalidade.calcularCusto(pedido);
        double prazo = modalidade.calcularPrazoEntrega(pedido);
        pedido.setStatus(StatusPedido.DESPACHADO);
        System.out.printf("Entrega solicitada (%s): custo R$ %.2f, prazo estimado %.0f dia(s)%n",
                modalidade, custo, prazo);
    }
}
