import valueobjects.InfoEntrega;

public class EntregaConvencional implements Entrega {
  private double tarifaFixa;
  private double fatorCarga;

  public EntregaConvencional(double t, double f) {
    tarifaFixa = t;
    fatorCarga = f;
  }

  @Override
  public InfoEntrega entregar(Pedido p) {
    double custo = tarifaFixa + p.getPeso() * fatorCarga;
    int prazo = Math.floorDiv((int) p.getDistancia(), 10);

    return new InfoEntrega(custo, prazo);
  }
}
