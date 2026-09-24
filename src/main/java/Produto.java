public class Produto {
  private String codigo;
  private String nome;
  private String validade;
  private Float preco;

  public Produto(String codigo, String nome, String validade, Float preco) {
    this.codigo = codigo;
    this.nome = nome;
    this.validade = validade;
    this.preco = preco;
  }

  public void setPreco(Float preco) {
    this.preco = preco;
  }

  public String getNome() {
    return this.nome;
  }

  public String getValidade() {
    return this.validade;
  }

  public Float getPreco() {
    return this.preco;
  }

  public String getCodigo() {
    return this.codigo;
  }

  @Override
  public String toString() {
    return "Código: " + codigo + 
            "\nNome: " + nome +
            "\nPreço: "  + preco +
            "\nValidade: " + validade; 
  }
}
