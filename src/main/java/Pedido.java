public class Pedido {
    private static int contador = 0;

    private final int id;
    private final Cliente cliente;
    private final Endereco origem;
    private final Endereco destino;
    private final double peso;
    private final double distanciaKm;
    private ModalidadeEntrega modalidade;
    private boolean despachado;

    public Pedido(Cliente cliente, Endereco origem, Endereco destino, double peso, double distanciaKm) {
        this.id = ++contador;
        this.cliente = cliente;
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.distanciaKm = distanciaKm;
        this.despachado = false;
    }

    public void alterarModalidade(ModalidadeEntrega nova) {
        if (despachado) {
            throw new IllegalStateException("Pedido " + id + " ja foi despachado: modalidade nao pode ser alterada.");
        }
        this.modalidade = nova;
    }

    public double calcularCusto() {
        verificarModalidade();
        return modalidade.calcularCusto(this);
    }

    public int calcularPrazoDias() {
        verificarModalidade();
        return modalidade.calcularPrazoDias(this);
    }

    public void despachar() {
        verificarModalidade();
        this.despachado = true;
    }

    private void verificarModalidade() {
        if (modalidade == null) {
            throw new IllegalStateException("Pedido " + id + " ainda nao possui modalidade de entrega.");
        }
    }

    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Endereco getOrigem() { return origem; }
    public Endereco getDestino() { return destino; }
    public double getPeso() { return peso; }
    public double getDistanciaKm() { return distanciaKm; }
    public ModalidadeEntrega getModalidade() { return modalidade; }
    public boolean isDespachado() { return despachado; }
}
