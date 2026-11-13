public class Pedido {
    private Cliente cliente;
    private String origem;
    private String destino;
    private double peso;
    private double distanciaEstimada;
    private ModalidadeEntrega modalidadeEntregaAtual;
    private boolean despachado;

    public Pedido(Cliente cliente, String origem, String destino,
                  double peso, double distancia) {
        this.cliente = cliente;
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.distanciaEstimada = distancia;
        this.despachado = false;
    }

    public void setModalidade(ModalidadeEntrega m) {
        if (despachado) {
            throw new IllegalStateException(
                "Não é possível alterar a modalidade de um pedido já despachado.");
        }
        this.modalidadeEntregaAtual = m;
    }

    public void despachar() {
        if (modalidadeEntregaAtual == null) {
            throw new IllegalStateException("Selecione uma modalidade antes de despachar.");
        }
        this.despachado = true;
    }

    public double calcularCustoEntrega() {
        verificarModalidade();
        return modalidadeEntregaAtual.calcularCusto(this.distanciaEstimada);
    }

    public int calcularPrazoEstimado() {
        verificarModalidade();
        return modalidadeEntregaAtual.calcularPrazo();
    }

    private void verificarModalidade() {
        if (modalidadeEntregaAtual == null) {
            throw new IllegalStateException("Nenhuma modalidade de entrega selecionada.");
        }
    }

    public double getDistancia() {
        return distanciaEstimada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getPeso() {
        return peso;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public boolean isDespachado() {
        return despachado;
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

    public void setDistanciaEstimada(double distanciaEstimada) {
        this.distanciaEstimada = distanciaEstimada;
    }
    
}