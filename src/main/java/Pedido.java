import valueobjects.Endereco;

public class Pedido {
  private Cliente cliente;
  private Endereco origem;
  private Endereco destino;
  private float peso;
  private float distancia;

  public Pedido(Cliente c, Endereco o, Endereco d, float p, float dist) {
    cliente = c;
    origem = o;
    destino = d;
    peso = p;
    distancia = dist;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public Endereco getOrigem() {
    return origem;
  }

  public Endereco getDestino() {
    return destino;
  }

  public float getPeso() {
    return peso;
  }

  public float getDistancia() {
    return distancia;
  }
}
