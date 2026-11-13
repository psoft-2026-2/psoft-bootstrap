import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Central {
    private static Central instance;

    private final List<Pedido> pedidos;
    private final List<String> historicoOperacoes;

    private Central() {
        this.pedidos = new ArrayList<>();
        this.historicoOperacoes = new ArrayList<>();
        registrarOperacao("Central inicializada");
    }

    public static Central getInstance() {
        if (instance == null) {
            synchronized (Central.class) {
                if (instance == null) {
                    instance = new Central();
                }
            }
        }
        return instance;
    }

    public Pedido criarPedido(Integer id, String nomeCliente, Endereco origem, Endereco destino,
                             double peso, double distanciakm, boolean estado) {
        Pedido pedido = new Pedido(id, nomeCliente, origem, destino, peso, distanciakm, estado);
        registrarPedido(pedido);
        registrarOperacao("Pedido criado: " + id + " - " + nomeCliente);
        return pedido;
    }

    public void registrarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo");
        }
        this.pedidos.add(pedido);
        registrarOperacao("Pedido registrado: " + pedido.getId());
    }

    public void registrarEntrega(Pedido pedido, Entrega entrega) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo");
        }
        if (entrega == null) {
            throw new IllegalArgumentException("Entrega não pode ser nula");
        }

        pedido.setModalidade(entrega);
        registrarOperacao("Entrega registrada para o pedido " + pedido.getId() + ": " + entrega.getClass().getSimpleName());
    }

    public Pedido buscarPedido(Integer id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(id)) {
                return pedido;
            }
        }
        return null;
    }

    public void atualizarEstadoPedido(Integer id, boolean estado) {
        Pedido pedido = buscarPedido(id);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado: " + id);
        }

        pedido.setEstado(estado);
        registrarOperacao("Estado do pedido " + id + " atualizado para: " + estado);
    }

    public List<Pedido> getPedidos() {
        return Collections.unmodifiableList(this.pedidos);
    }

    public List<String> getHistoricoOperacoes() {
        return Collections.unmodifiableList(this.historicoOperacoes);
    }

    public void registrarOperacao(String operacao) {
        this.historicoOperacoes.add(operacao);
    }
}
