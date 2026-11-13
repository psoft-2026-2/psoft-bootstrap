public class Pedido {

    private Cliente cliente;
    private EntregaI entrega;
    private String origem;
    private String destino;
    private float peso;
    private float distancia;
    private boolean despachado;

    public Pedido(Cliente cliente, String origem, String destino, float peso, float distancia) {
        this.cliente = cliente;
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.distancia = distancia;
        this.despachado = false;
    }

    public void setModalidadeEntrega(EntregaI entrega) {
        if (despachado) {
            throw new IllegalStateException("Pedido ja foi despachado");
        }
        this.entrega = entrega;
    }

    public void despachar() {
        this.despachado = true;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public EntregaI getEntrega() {
        return entrega;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public float getPeso() {
        return peso;
    }

    public float getDistancia() {
        return distancia;
    }

    public boolean isDespachado() {
        return despachado;
    }
}
