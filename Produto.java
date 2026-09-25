public class Produto {
  private String nome;
  private float valor;
  private String cod;

  public Produto(String nome, float valor, String cod) {
    this.nome = nome;
    this.cod = cod;
    this.valor = valor;
  }
  
  public String getCod(){
    return this.cod;
  }
  
  public float getValor(){
    return this.valor;
  }

  public String getNome(){
    return this.nome;
  }
  @Override 
  public String toString(){
    return "Produto: " + this.nome + " - R$ " + String.format("%.2f", this.valor);
  }
}