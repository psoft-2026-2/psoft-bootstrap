import valueobjects.InfoEntrega;

public class EntregaEconomica implements Entrega {
  private float fatorCarga;

  public EntregaEconomica(float f) {
    fatorCarga = f;
  }

  @Override
  public InfoEntrega entregar(Pedido p) {
    float custo = p.getPeso() * fatorCarga;
    int prazo = Math.floorDiv((int) p.getDistancia(), 5);

    return new InfoEntrega(custo, prazo);
  }
}
