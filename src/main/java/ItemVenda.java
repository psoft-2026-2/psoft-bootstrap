public class ItemVenda {

  private Produto produto;
  private Integer quantidade;
  private Float subTotal;

  public ItemVenda(Produto produto, Integer quantidade) {
    this.produto = produto;
    this.quantidade = quantidade;
    this.subTotal = calcularSubTotal();
  }

  public Float calcularSubTotal() {
    Float preco = produto.getPreco();

    if (quantidade >= 20) {
      preco = preco * 0.9f;
    }

    return preco * quantidade;
  }

  public String getProduto() {
    return this.produto.toString();
  }

  public Integer getQauntidade() {
    return this.quantidade;
  }

  public Float getSubTotal() {
    return this.subTotal;
  }

  @Override
  public String toString() {
    return "Produto: " + produto.getNome() +
           "\nQuantidade: " + quantidade +
           "\nSubTotal: " + subTotal;
  }
}
