package logistica;

import java.util.ArrayList;
import java.util.List;

public class CentralLogistica {

    private static final CentralLogistica INSTANCIA = new CentralLogistica();

    private final List<Pedido> pedidos = new ArrayList<>();

    private CentralLogistica() {
    }

    public static CentralLogistica getInstance() {
        return INSTANCIA;
    }

    public void registrarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido é obrigatório");
        }
        if (pedidos.contains(pedido)) {
            throw new IllegalArgumentException("Pedido já registrado");
        }
        pedidos.add(pedido);
    }

    public void selecionarModalidade(Pedido pedido, ModalidadeEntrega modalidade) {
        exigirRegistrado(pedido);
        pedido.setModalidade(modalidade);
    }

    public Cotacao solicitarEntrega(Pedido pedido) {
        exigirRegistrado(pedido);
        ModalidadeEntrega modalidade = pedido.getModalidade();
        if (modalidade == null) {
            throw new IllegalStateException("Selecione uma modalidade de entrega");
        }
        return new Cotacao(modalidade.calcularCusto(pedido), modalidade.calcularPrazo(pedido));
    }

    public void despachar(Pedido pedido) {
        exigirRegistrado(pedido);
        pedido.despachar();
    }

    public String acompanharPedido(Pedido pedido) {
        exigirRegistrado(pedido);
        ModalidadeEntrega modalidade = pedido.getModalidade();
        String nomeModalidade = modalidade == null ? "não selecionada" : modalidade.nome();
        return String.format("Pedido de %s: %s -> %s | status: %s | modalidade: %s",
                pedido.getCliente(), pedido.getOrigem(), pedido.getDestino(),
                pedido.getStatus(), nomeModalidade);
    }

    private void exigirRegistrado(Pedido pedido) {
        if (pedido == null || !pedidos.contains(pedido)) {
            throw new IllegalArgumentException("Pedido não registrado na central");
        }
    }
}
