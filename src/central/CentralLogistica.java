package central;

import entrega.Entrega;
import modelo.Cliente;
import modelo.Pedido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CentralLogistica {
    private static final CentralLogistica instancia = new CentralLogistica();

    private List<Pedido> pedidos;

    private CentralLogistica() {
        this.pedidos = new ArrayList<>();
    }

    public static CentralLogistica getInstance() {
        return instancia;
    }

    public Pedido adicionaPedido(String origem, String destino, double peso, double distancia, Cliente cliente, Entrega entregaTipo) {
        Pedido novoPedido = new Pedido(origem, destino, peso, distancia, cliente, entregaTipo);
        pedidos.add(novoPedido);
        return novoPedido;
    }

    public void despachaPedido(Pedido pedido) {
        verificaRegistro(pedido);
        pedido.despachar();
    }

    public void alteraModalidadePedido(Pedido pedido, Entrega entrega) {
        verificaRegistro(pedido);
        pedido.setEntrega(entrega);
    }

    public List<Pedido> getPedidos() {
        return Collections.unmodifiableList(pedidos);
    }

    private void verificaRegistro(Pedido pedido) {
        if (pedido == null || !pedidos.contains(pedido)) {
            throw new IllegalArgumentException("Pedido não registrado na central.");
        }
    }
}