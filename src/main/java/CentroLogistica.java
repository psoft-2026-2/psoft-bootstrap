import java.util.ArrayList;
import java.util.List;

import valueobjects.InfoEntrega;

public class CentroLogistica {
  private static CentroLogistica instance = null;
  private List<Pedido> pedidos;
  private List<InfoEntrega> entregas;
  private Entrega estrategiaEntrega;

  private CentroLogistica() {
    pedidos = new ArrayList<>();
    entregas = new ArrayList<>();
    estrategiaEntrega = new EntregaConvencional(15.0, 1.5);
  }

  public static CentroLogistica getInstance() {
    if (instance == null) {
      instance = new CentroLogistica();
    }

    return instance;
  }

  public void fazerPedido(Pedido p) {
    pedidos.add(p);
  }

  public List<Pedido> listarPedidos() {
    return pedidos;
  }

  public void setEstrategiaEntrega(Entrega e) {
    estrategiaEntrega = e;
  }

  public InfoEntrega entregarPedido(int index) {
    InfoEntrega e = estrategiaEntrega.entregar(pedidos.get(index));
    entregas.add(e);
    return e;
  }

  public InfoEntrega acompanharEntrega(int index) {
    return entregas.get(index);
  }
}
