public class Pedido {

    private Long id;
    private Cliente cliente;
    private String destino;
    private String origem;
    private double peso;
    private double distancia;
    private Entrega entrega;

    public Pedido(Cliente cliente, String destino, String origem, double peso, double distancia) {
        this(null, cliente, destino, origem, peso, distancia);
    }

    Pedido(Long id, Cliente cliente, String destino, String origem, double peso, double distancia) {
        this.id = id;
        this.cliente = cliente;
        this.destino = destino;
        this.origem = origem;
        this.peso = peso;
        this.distancia = distancia;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public double calcularTempo() {
        return entrega.calcularTempo(this);
    }

    public double calcularCusto() {
        return entrega.calcularCusto(this);
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigem() {
        return origem;
    }

    public double getPeso() {
        return peso;
    }

    public double getDistancia() {
        return distancia;
    }

}
