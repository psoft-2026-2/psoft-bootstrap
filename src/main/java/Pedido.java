public class Pedido {
    private final int id;
    private final Cliente cliente;
    private String origem;
    private String destino;
    private double peso;
    private double distancia;
    private ModalidadeEntrega modalidade;
    private StatusPedido status = StatusPedido.REGISTRADO;

    public Pedido(int id, Cliente cliente, String origem, String destino, double peso, double distanciaKm) {
        this.id = id;
        this.cliente = cliente;
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.distancia = distanciaKm;
    }

    public void setModalidade(ModalidadeEntrega nova) {
        if (status == StatusPedido.DESPACHADO)
            throw new IllegalStateException("Pedido " + id + " já foi despachado.");
        this.modalidade = nova;
    }

    public double calcularCusto() { 
        return exigirModalidade().calcularCusto(this); 
    }

    public int calcularPrazo() { 
        return exigirModalidade().calcularPrazo(this); 
    }

    public void despachar() {
        exigirModalidade();
        status = StatusPedido.DESPACHADO;
    }

    private ModalidadeEntrega exigirModalidade() {
        if (modalidade == null)
            throw new IllegalStateException("Pedido " + id + " sem modalidade selecionada.");
        return modalidade;
    }

    public int getId() { 
        return id; 
    }

    public Cliente getCliente() { 
        return cliente; 
    }

    public String getOrigem() { 
        return origem; }

    public String getDestino() { 
        return destino; 
    }

    public double getPeso() { 
        return peso; 
    }

    public double getDistancia() { 
        return distancia; 
    }

    public StatusPedido getStatus() { 
        return status; 
    }

    public ModalidadeEntrega getModalidade() { 
        return modalidade; 
    }

    @Override
    public String toString() {
        return String.format("Pedido #%d | %s | %s -> %s | %s | %s",
            id, cliente.getNome(), origem, destino, modalidade.getModalidade(), status);
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}