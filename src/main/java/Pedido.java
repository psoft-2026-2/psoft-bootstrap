public class Pedido {
    private String cliente;
    private String enderecoOrigem;
    private String enderecoDestino;
    private double peso;
    private double distanciaEstimada;
    private ModalidadeEntrega modalidade;
    private boolean despachado;

    public Pedido(String cliente, String enderecoOrigem, String enderecoDestino,
                  double peso, double distanciaEstimada, ModalidadeEntrega modalidade) {
        this.cliente = cliente;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.peso = peso;
        this.distanciaEstimada = distanciaEstimada;
        this.modalidade = modalidade;
        this.despachado = false;
    }

    public void alterarModalidade(ModalidadeEntrega novaModalidade) {
        if (this.despachado) {
            throw new IllegalStateException("Não é possível alterar a modalidade de um pedido já despachado.");
        }
        this.modalidade = novaModalidade;
    }

    public double calcularCusto() {
        return this.modalidade.calcularCusto(this);
    }

    public int calcularPrazo() {
        return this.modalidade.calcularPrazo(this);
    }

    public void despachar() {
        this.despachado = true;
    }

    public String getCliente() {
        return cliente;
    }

    public String getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public double getPeso() {
        return peso;
    }

    public double getDistanciaEstimada() {
        return distanciaEstimada;
    }

    public ModalidadeEntrega getModalidade() {
        return modalidade;
    }

    public boolean isDespachado() {
        return despachado;
    }
}