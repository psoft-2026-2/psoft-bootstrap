public class Pedido {

    private Entrega modalidadeEntrega;
    private boolean despachado;
    private Cliente cliente;
    private Double peso;
    private String origem;
    private String destino;
    private Long distanciaEstimada;

    public Pedido(Cliente cliente, Double peso, String origem, String destino, Long distanciaEstimada, Entrega modalidadeEntrega) {
        this.cliente = cliente;
        this.peso = peso;
        this.origem = origem;
        this.destino = destino;
        this.distanciaEstimada = distanciaEstimada;
        this.modalidadeEntrega = modalidadeEntrega;
        this.despachado = false;
    }

    public void enviar() {
        this.despachado = true;
    }

    public Double getCustoEntrega() {
        return modalidadeEntrega.getPreco(distanciaEstimada);
    }

    public int getPrazoEntrega() {
        return modalidadeEntrega.getPrazo();
    }

    public void setModalidadeEntrega(Entrega entrega) {
        if (!this.despachado) {
            this.modalidadeEntrega = entrega;
        }
    }
}
