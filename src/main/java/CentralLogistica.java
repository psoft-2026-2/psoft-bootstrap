import java.util.ArrayList;
import java.util.List;

public class CentralLogistica {
    private static CentralLogistica instancia;
    private final List<Pedido> pedidos;

    private CentralLogistica() {
        this.pedidos = new ArrayList<>();
    }

    public static synchronized CentralLogistica getInstancia() {
        if (instancia == null) {
            instancia = new CentralLogistica();
        }
        return instancia;
    }

    public void registrarPedido(Pedido p) {
        pedidos.add(p);
    }

    public void despachar(Pedido p) {
        if (!pedidos.contains(p)) {
            throw new IllegalArgumentException("Pedido nao registrado na central.");
        }
        p.despachar();
    }

    public String acompanhar(Pedido p) {
        return "Cliente: " + p.getCliente().getNome()
             + " | Custo: R$ " + String.format("%.2f", p.calcularCusto())
             + " | Prazo: " + p.calcularPrazo() + " dia(s)"
             + " | Status: " + (p.isDespachado() ? "Despachado" : "Aguardando despacho");
    }

    public List<Pedido> getPedidos() {
        return new ArrayList<>(pedidos);
    }
}
