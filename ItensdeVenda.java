public class ItensdeVenda {
  private int quantidade;
  private Produto produto;
  private float valor;

  public ItensdeVenda(int quantidade, Produto produto) {
    this.quantidade = quantidade;
    this.produto = produto;
    this.valor = quantidade * this.produto.getValor();
  }

  public float getValor() {
    return this.valor;
  }

  @Override
  public String toString() {
    return this.quantidade + "x " + this.produto.getNome() + " - R$ " + String.format("%.2f", this.valor);
  }
}

}