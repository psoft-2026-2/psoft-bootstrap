import valueobjects.InfoEntrega;

public class EntregaExpressa implements Entrega {
  private float tarifaExpressa;
  private float fatorCarga;

  public EntregaExpressa(float t, float f) {
    tarifaExpressa = t;
    fatorCarga = f;
  }

  @Override
  public InfoEntrega entregar(Pedido p) {
    float custo = tarifaExpressa * p.getPeso() * fatorCarga;
    int prazo = Math.floorDiv((int) p.getDistancia(), 20);

    return new InfoEntrega(custo, prazo);
  }
}
