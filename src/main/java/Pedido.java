public class Pedido {
    private String cliente;
    private String enderecoOrigem;
    private String enderecoDestino;
    private float peso;
    private float distancia;
    private ModalidadeStrategy modalidadeEntrega;
    private boolean despachado;

    public Pedido(String cliente, String origem, String destino, float peso, float distancia, ModalidadeStrategy mod) {
        this.cliente = cliente;
        this.enderecoOrigem = origem;
        this.enderecoDestino = destino;
        this.peso = peso;
        this.distancia = distancia;
        this.modalidadeEntrega = mod;
    }

    public float calcularCusto() {
        if (modalidadeEntrega == null) throw new IllegalStateException("Pedido sem modalidade de entrega");
        return modalidadeEntrega.calcularCusto(this);
    }

    public float calcularPrazo() {
        if (modalidadeEntrega == null) throw new IllegalStateException("Pedido sem modalidade de entrega");
        return modalidadeEntrega.calcularPrazo(this);
    }

    public void alterarModalidade(ModalidadeStrategy modalidade) {
        if (modalidade == null) throw new IllegalArgumentException("Modalidade não pode ser nula");
        if (despachado) throw new IllegalStateException("Pedido já foi despachado");
        this.modalidadeEntrega = modalidade;
    }

    public void despachar() {
        if (modalidadeEntrega == null) throw new IllegalStateException("Pedido sem modalidade de entrega");
        this.despachado = true;
    }

    public ModalidadeStrategy getModalidadeEntrega() {
        return modalidadeEntrega;
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