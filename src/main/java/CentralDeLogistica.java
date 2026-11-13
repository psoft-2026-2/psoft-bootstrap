import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CentralDeLogistica {
    private static CentralDeLogistica instance;
    private final List<Pedido> pedidos;

    private CentralDeLogistica() {
        pedidos = new ArrayList<>();
    }

    public static synchronized CentralDeLogistica getInstance() {
        if (instance == null) {
            instance = new CentralDeLogistica();
        }
        return instance;
    }

    public synchronized void registrarPedido(Pedido pedido) {
        Pedido novoPedido = Objects.requireNonNull(pedido, "O pedido é obrigatório");
        if (localizarPedido(novoPedido.getNumero()) != null) {
            throw new IllegalArgumentException("Já existe um pedido com o número " + novoPedido.getNumero() + ".");
        }
        pedidos.add(novoPedido);
    }

    public synchronized void selecionarModalidade(Pedido pedido, EstrategiaEntrega estrategia) {
        Pedido pedidoRegistrado = exigirPedidoRegistrado(pedido);
        pedidoRegistrado.setEstrategia(estrategia);
    }

    public synchronized void selecionarModalidade(int numero, EstrategiaEntrega estrategia) {
        buscarPedido(numero).setEstrategia(estrategia);
    }

    public synchronized void despacharPedido(int numero) {
        buscarPedido(numero).despachar();
    }

    public synchronized void iniciarTransporte(int numero) {
        buscarPedido(numero).iniciarTransporte();
    }

    public synchronized void registrarEntrega(int numero) {
        buscarPedido(numero).entregar();
    }

    public synchronized Pedido acompanharPedido(int numero) {
        return buscarPedido(numero);
    }

    public synchronized List<Pedido> listarPedidos() {
        return Collections.unmodifiableList(new ArrayList<>(pedidos));
    }

    private Pedido exigirPedidoRegistrado(Pedido pedido) {
        Pedido informado = Objects.requireNonNull(pedido, "O pedido é obrigatório");
        Pedido registrado = buscarPedido(informado.getNumero());
        if (registrado != informado) {
            throw new IllegalArgumentException("O pedido informado não é o pedido registrado nesta central.");
        }
        return registrado;
    }

    private Pedido buscarPedido(int numero) {
        Pedido pedido = localizarPedido(numero);
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido " + numero + " não existe no sistema.");
        }
        return pedido;
    }

    private Pedido localizarPedido(int numero) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumero() == numero) {
                return pedido;
            }
        }
        return null;
    }
}
