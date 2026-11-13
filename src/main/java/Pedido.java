public class Pedido {

    private Cliente cliente;
    private int id;
    private String enderecoOrigem;
    private String enderecoDestino;
    private double peso;
    private double distanciaEstimada;
    private ModalidadeStrategy modalidadeEntrega;
    private boolean despachado;

    public Pedido(Cliente cliente, int id, String origem, String destino, double peso, double distancia, ModalidadeStrategy modalidade) {
        if (distancia < 0) throw new IllegalArgumentException("Distancia deve ser positiva");
        this.cliente = cliente;
        this.id = id;
        this.enderecoOrigem = origem;
        this.enderecoDestino = destino;
        this.peso = peso;
        this.distanciaEstimada = distancia;
        this.modalidadeEntrega = modalidade;
    }

    public double calcularCusto() {
        if (modalidadeEntrega == null) throw new IllegalArgumentException("Pedido sem modalidade de entrega");
        return modalidadeEntrega.calcularCusto(this);
    }

    public int prazoEstimado() {
        if (modalidadeEntrega == null) throw new IllegalArgumentException("Pedido sem modalidade de entrega");
        return modalidadeEntrega.prazoEstimado(this);
    }

    public void setModalidadeEntrega(ModalidadeStrategy modalidade) {
        if (modalidade == null) throw new IllegalArgumentException("Modalidade não pode ser vazia");
        if (despachado) throw new IllegalArgumentException("Não é possivel alterar a modalidade de um pedido despachado");
        this.modalidadeEntrega = modalidade;
    }

    public void despachar() {
        if (modalidadeEntrega == null) throw new IllegalArgumentException("Pedido sem modalidade de entrega");
        this.despachado = true;
    }

    public ModalidadeStrategy getModalidadeEntrega() {
        return this.modalidadeEntrega;
    }

    public double getPeso() {
        return this.peso;
    }

    public double getDistanciaEstimada() {
        return this.distanciaEstimada;
    }

    public boolean isDespachado() {
        return this.despachado;
    }

    public int getId() {
        return this.id;
    }
}