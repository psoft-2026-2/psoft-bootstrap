package valueobjects;

public class InfoEntrega {
  private double custo;
  private int prazo;
  private boolean entregue;

  public InfoEntrega(double c, int p) {
    custo = c;
    prazo = p;
    entregue = false;
  }

  public double getCusto() {
    return custo;
  }

  public void setCusto(double custo) {
    this.custo = custo;
  }

  public int getPrazo() {
    return prazo;
  }

  public void setPrazo(int prazo) {
    this.prazo = prazo;
  }

  public boolean isEntregue() {
    return entregue;
  }

  public void setEntregue(boolean entregue) {
    this.entregue = entregue;
  }
}