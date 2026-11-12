package java;

import java.util.HashMap;
import java.util.Map;

public class Central {
    private static final Central INSTANCIA = new Central();

    private final Map<String, Pedido> pedidos = new HashMap<>();
    private final Map<String, Modalidade> modalidades = new HashMap<>();

    private Central() {
    }

    public static Central getInstance() {
        return INSTANCIA;
    }

    public void cadastrarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido nao pode ser nulo.");
        }
        pedidos.put(pedido.getId(), pedido);
    }

    public void cadastrarModalidade(String nome, Modalidade modalidade) {
        if (nome == null || nome.isBlank() || modalidade == null) {
            throw new IllegalArgumentException("Nome e modalidade sao obrigatorios.");
        }
        modalidades.put(nome, modalidade);
    }

    public void alterarModalidadePedido(String idPedido, String nomeModalidade) {
        Pedido pedido = buscarPedido(idPedido);
        pedido.alterarModalidade(buscarModalidade(nomeModalidade));
    }

    public double calcularCustoPedido(String idPedido) {
        return buscarPedido(idPedido).calcularCusto();
    }

    public int calcularPrazoPedido(String idPedido) {
        return buscarPedido(idPedido).calcularPrazo();
    }

    private Pedido buscarPedido(String idPedido) {
        Pedido pedido = pedidos.get(idPedido);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido nao encontrado: " + idPedido);
        }
        return pedido;
    }

    private Modalidade buscarModalidade(String nomeModalidade) {
        Modalidade modalidade = modalidades.get(nomeModalidade);
        if (modalidade == null) {
            throw new IllegalArgumentException("Modalidade nao encontrada: " + nomeModalidade);
        }
        return modalidade;
    }
}

