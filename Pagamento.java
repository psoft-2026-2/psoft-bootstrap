public class Pagamento {
  private String tipo;
  private float valor;

  public Pagamento(String tipo, float valor) {
    this.tipo = tipo;
    this.valor = valor;
  }

  @Override
  public String toString() {
    return "Pagamento: " + this.tipo + " - R$ " + this.valor;
  }
}