import java.util.ArrayList;
import java.util.List;

public class CentralDeLogistica {
    private static CentralDeLogistica instancia;
    private List<Pedido> pedidos;
    private List<Frete> fretes;

    private CentralDeLogistica() {
        this.pedidos = new ArrayList<>();
        this.fretes = new ArrayList<>();
    }

    public static CentralDeLogistica getInstancia() {
        if (instancia == null) {
            instancia = new CentralDeLogistica();
        }
        return instancia;
    }

    public Pedido getPedido(int indice) {
        return pedidos.get(indice);
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void addFrete(Frete frete) {
        fretes.add(frete);
    }

    public void alterarFrete(Pedido pedido, Frete novoFrete) {
        pedido.setFrete(novoFrete);
    }

    public void despacharPedido(Pedido pedido) {
        pedido.despachar();
    }

    public double calcularFrete(Pedido pedido) {
        return pedido.getFrete().calcular(pedido);
    }

    public String calcularPrazo(Pedido pedido) {
        return pedido.getFrete().calcularPrazo(pedido);
    }

    public List<Pedido> getPedidos() { 
        return List.copyOf(pedidos); 
    }

    public List<Frete> getFretes() { 
        return List.copyOf(fretes); 
    }
}
