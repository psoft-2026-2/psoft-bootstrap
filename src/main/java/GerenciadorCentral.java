import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GerenciadorCentral {
    private static GerenciadorCentral instance;
    private List<Pedido> pedidos;
    private List<Entrega> entregas;

    private GerenciadorCentral() {
        pedidos = new ArrayList<>();
        entregas = new ArrayList<>();
    }

    public static synchronized GerenciadorCentral getInstance() {
        if (instance == null) instance = new GerenciadorCentral();
        return instance;
    }

    public Entrega selecionarModalidade() {
        return entregas.isEmpty() ? null : entregas.get(0);
    }

    public Entrega selecionarModalidade(Entrega entrega) {
        if (entrega == null) throw new IllegalArgumentException("Entrega obrigatoria");
        if (!entregas.contains(entrega)) entregas.add(entrega);
        return entrega;
    }

    public void cadastrarEntrega(Entrega entrega) {
        if (entrega == null) throw new IllegalArgumentException("Entrega obrigatoria");
        entregas.add(entrega);
    }

    public void cadastrarPedido(Pedido pedido) {
        if (pedido == null) throw new IllegalArgumentException("Pedido obrigatorio");
        pedidos.add(pedido);
        if (pedido.getEntrega() != null && !entregas.contains(pedido.getEntrega())) {
            entregas.add(pedido.getEntrega());
        }
    }

    public void mudarModalidade(Entrega entrega) {
        if (entrega == null) throw new IllegalArgumentException("Entrega obrigatoria");
        for (Pedido pedido : pedidos) {
            if (pedido.getEntrega() != null && !pedido.estaDespachado()) {
                mudarModalidade(pedido, entrega);
                return;
            }
        }
        cadastrarEntrega(entrega);
    }

    public void mudarModalidade(Pedido pedido, Entrega entrega) {
        if (pedido == null || entrega == null) throw new IllegalArgumentException("Pedido e entrega sao obrigatorios");
        if (!pedidos.contains(pedido)) throw new IllegalArgumentException("Pedido nao cadastrado");
        if (pedido.estaDespachado()) throw new IllegalStateException("Pedido ja despachado");
        pedido.associarEntrega(entrega);
        if (!entregas.contains(entrega)) entregas.add(entrega);
    }

    public List<Pedido> listarPedidos() { return Collections.unmodifiableList(new ArrayList<>(pedidos)); }
    public List<Entrega> listarEntregas() { return Collections.unmodifiableList(new ArrayList<>(entregas)); }

    public double calcularCusto(Entrega entrega) {
        if (entrega == null) throw new IllegalArgumentException("Entrega obrigatoria");
        return entrega.calcularCusto();
    }

    public Date verificarPrazo(Entrega entrega) {
        if (entrega == null) throw new IllegalArgumentException("Entrega obrigatoria");
        long prazo = entrega.prazoEstimado() * 24L * 60L * 60L * 1000L;
        return new Date(System.currentTimeMillis() + prazo);
    }

    public void removerEntrega(Entrega entrega) {
        if (entrega == null) throw new IllegalArgumentException("Entrega obrigatoria");
        entregas.remove(entrega);
    }

    public void acompanharOperacao() {
        System.out.println("Pedidos: " + pedidos.size() + ", entregas: " + entregas.size());
    }
}
