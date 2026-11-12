package central;

import modalidade.ModalidadeEntrega;
import modelo.Cliente;
import modelo.Cotacao;
import modelo.Endereco;
import modelo.Pedido;

import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class CentralLogistica {

    private final Map<Integer, Pedido> pedidos = new ConcurrentHashMap<>();
    private final AtomicInteger proximoId = new AtomicInteger(1);

    private CentralLogistica() {
    }

    private static final class Holder {
        private static final CentralLogistica INSTANCIA = new CentralLogistica();
    }

    public static CentralLogistica getInstance() {
        return Holder.INSTANCIA;
    }

    public Pedido registrarPedido(Cliente cliente, Endereco origem, Endereco destino,
                                  double pesoKg, double distanciaKm) {
        Pedido pedido = new Pedido(proximoId.getAndIncrement(), cliente, origem, destino, pesoKg, distanciaKm);
        pedidos.put(pedido.getId(), pedido);
        return pedido;
    }

    public void selecionarModalidade(int idPedido, ModalidadeEntrega modalidade) {
        buscarPedido(idPedido).definirModalidade(modalidade);
    }

    public void alterarModalidade(int idPedido, ModalidadeEntrega novaModalidade) {
        selecionarModalidade(idPedido, novaModalidade);
    }

    public Cotacao solicitarEntrega(int idPedido) {
        return buscarPedido(idPedido).calcularCotacao();
    }

    public void despachar(int idPedido) {
        buscarPedido(idPedido).despachar();
    }

    public Pedido buscarPedido(int idPedido) {
        Pedido pedido = pedidos.get(idPedido);
        if (pedido == null) {
            throw new NoSuchElementException("Pedido " + idPedido + " não encontrado.");
        }
        return pedido;
    }

    public Collection<Pedido> listarPedidos() {
        return pedidos.values();
    }
}
