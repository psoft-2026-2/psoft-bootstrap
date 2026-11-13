import java.util.ArrayList;
import java.util.List;

public final class CentralLogistica {
    private static final CentralLogistica instancia = new CentralLogistica();
    private final List<Pedido> pedidos = new ArrayList<>();

    private CentralLogistica() {}

    public static CentralLogistica getInstancia() { return instancia; }

    public void registrarPedido(Pedido pedido) {
        if (pedido == null) throw new IllegalArgumentException("pedido nao pode ser nulo");
        if (pedidos.contains(pedido)) throw new IllegalArgumentException("pedido ja registrado");
        pedidos.add(pedido);
    }

    public void selecionarModalidade(Pedido pedido, Entrega entrega) {
        verificarRegistro(pedido);
        pedido.alterarModalidade(entrega);
    }

    public void despacharPedido(Pedido pedido) {
        verificarRegistro(pedido);
        pedido.despachar();
    }

    public String acompanharPedido(Pedido pedido) {
        verificarRegistro(pedido);
        String modalidade = pedido.getTipoEntrega() == null ? "nao selecionada" : pedido.getTipoEntrega().getClass().getSimpleName();
        String valores = pedido.getTipoEntrega() == null ? "frete e prazo ainda nao calculados" :
                String.format("frete=%.2f, prazo=%d dias", pedido.getFrete(), pedido.getPrazoEstimado());
        return String.format("Pedido de %s: %s; modalidade=%s; %s", pedido.getCliente().getNome(),
                pedido.isDespachado() ? "despachado" : "pendente", modalidade, valores);
    }

    public List<Pedido> listarPedidos() { return List.copyOf(pedidos); }

    private void verificarRegistro(Pedido pedido) {
        if (pedido == null || !pedidos.contains(pedido)) throw new IllegalArgumentException("pedido nao registrado");
    }
}
