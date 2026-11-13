import java.util.ArrayList;

public class Empresa {

    private static Empresa empresa;
    private ArrayList<Pedido> pedidos;
    private long proximoId;

    private Empresa() {
        pedidos = new ArrayList<>();
        proximoId = 1L;
    }

    public static Empresa getEmpresa() {
        if (empresa == null) {
            empresa = new Empresa();
        }
        return empresa;
    }

    public Long adicionarPedido(String origem, String destino, double peso) {
        return adicionarPedido(
                new Cliente(String.valueOf(proximoId), "Cliente padrão"),
                origem,
                destino,
                peso,
                100.0
        );
    }

    public Long adicionarPedido(
            Cliente cliente,
            String origem,
            String destino,
            double peso,
            double distancia
    ) {
        Long id = proximoId++;
        pedidos.add(new Pedido(
                id,
                cliente,
                destino,
                origem,
                peso,
                distancia
        ));
        return id;
    }

    public void setModalidadeEntregaPedido(Long id, Entrega entrega) {
        Pedido pedido = buscarPedido(id);
        if (pedido != null) {
            pedido.setEntrega(entrega);
        }
    }

    public Pedido getPedido(Long id) {
        return buscarPedido(id);
    }

    private Pedido buscarPedido(Long id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(id)) {
                return pedido;
            }
        }
        return null;
    }
}
