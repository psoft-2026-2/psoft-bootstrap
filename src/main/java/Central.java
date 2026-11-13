import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Central {
    private static final Central INSTANCIA = new Central();
    private final List<Pedido> pedidos = new ArrayList<>();
    private final List<Entrega> entregas = new ArrayList<>();

    private Central() { }

    public static Central getInstancia() { return INSTANCIA; }
    public List<Pedido> getPedidos() { return List.copyOf(pedidos); }
    public List<Entrega> getEntregas() { return List.copyOf(entregas); }

    public int custoPedido(Modalidade modalidade, Pedido pedido) {
        return Objects.requireNonNull(modalidade).custo(Objects.requireNonNull(pedido));
    }

    public int prazoPedido(Modalidade modalidade, Pedido pedido) {
        return Objects.requireNonNull(modalidade).prazo(Objects.requireNonNull(pedido));
    }

    public void addPedido(Pedido pedido) {
        Objects.requireNonNull(pedido, "Pedido obrigatório.");
        if (pedidos.contains(pedido)) throw new IllegalArgumentException("Pedido já cadastrado.");
        pedidos.add(pedido);
    }

    public void criarEntrega(Pedido pedido, Modalidade modalidade) {
        criarEntrega(pedido, modalidade, custoPedido(modalidade, pedido), prazoPedido(modalidade, pedido));
    }

    public void criarEntrega(Pedido pedido, Modalidade modalidade, int custo, int prazo) {
        if (!pedidos.contains(pedido)) throw new IllegalArgumentException("Pedido não cadastrado.");
        if (entregas.stream().anyMatch(entrega -> entrega.getPedido() == pedido)) {
            throw new IllegalArgumentException("Pedido já possui entrega.");
        }
        if (custo != custoPedido(modalidade, pedido) || prazo != prazoPedido(modalidade, pedido)) {
            throw new IllegalArgumentException("Custo e prazo devem seguir a modalidade selecionada.");
        }
        entregas.add(new Entrega(pedido, modalidade, custo, prazo));
    }
}
