public class Pedido {
    private Cliente cliente;
    private String status;
    private String enderecoDestino;
    private String enderecoOrigem;
    private double peso;
    private double distancia;
    private Entrega entrega;

    public Pedido(Cliente cliente, String status, String enderecoDestino,
                  String enderecoOrigem, double peso, double distancia) {
        this(cliente, status, enderecoDestino, enderecoOrigem, peso, distancia, null);
    }

    public Pedido(Cliente cliente, String status, String enderecoDestino,
                  String enderecoOrigem, double peso, double distancia,
                  Entrega entrega) {
        if (cliente == null || status == null || status.trim().isEmpty()
                || enderecoDestino == null || enderecoOrigem == null
                || !Double.isFinite(peso) || peso < 0
                || !Double.isFinite(distancia) || distancia < 0) {
            throw new IllegalArgumentException("Dados invalidos do pedido");
        }
        this.cliente = cliente;
        this.status = status;
        this.enderecoDestino = enderecoDestino;
        this.enderecoOrigem = enderecoOrigem;
        this.peso = peso;
        this.distancia = distancia;
        this.entrega = entrega;
    }

    public Cliente getCliente() { return cliente; }
    public double getDistancia() { return distancia; }
    public double getPeso() { return peso; }
    public String getEnderecoOrigem() { return enderecoOrigem; }
    public String getEnderecoDestino() { return enderecoDestino; }
    public String getEnderecoFinal() { return enderecoDestino; }
    public String getStatus() { return status; }
    public Entrega getEntrega() { return entrega; }

    public void despachar() { status = "DESPACHADO"; }

    boolean estaDespachado() {
        return "DESPACHADO".equalsIgnoreCase(status);
    }

    void associarEntrega(Entrega entrega) {
        this.entrega = entrega;
    }
}
