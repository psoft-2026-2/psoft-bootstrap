public class Pedido {
    private final int id;
    private final Cliente cliente;
    private final Endereco origem;
    private final Endereco destino;
    private final double pesoKg;
    private final double distanciaKm;

    private ModalidadeEntrega modalidade;
    private StatusPedido status = StatusPedido.CRIADO;
    private double custoEstimado;
    private int prazoEstimadoDias;

    public Pedido(int id, Cliente cliente, Endereco origem, Endereco destino,
                  double pesoKg, double distanciaKm) {
        this.id = id;
        this.cliente = cliente;
        this.origem = origem;
        this.destino = destino;
        this.pesoKg = pesoKg;
        this.distanciaKm = distanciaKm;
    }

    /** Define a modalidade; só é permitido antes do despacho. */
    void definirModalidade(ModalidadeEntrega nova) {
        if (status == StatusPedido.DESPACHADO) {
            throw new IllegalStateException("Pedido " + id + " já foi despachado.");
        }
        this.modalidade = nova;
        if (status == StatusPedido.ENTREGA_SOLICITADA) {
            recalcular(); // mantém custo e prazo coerentes com a nova modalidade
        }
    }

    void solicitarEntrega() {
        if (modalidade == null) {
            throw new IllegalStateException("Selecione uma modalidade antes de solicitar a entrega.");
        }
        recalcular();
        status = StatusPedido.ENTREGA_SOLICITADA;
    }

    void despachar() {
        if (status != StatusPedido.ENTREGA_SOLICITADA) {
            throw new IllegalStateException("A entrega ainda não foi solicitada.");
        }
        status = StatusPedido.DESPACHADO;
    }

    private void recalcular() {
        this.custoEstimado = modalidade.calcularCusto(this);
        this.prazoEstimadoDias = modalidade.calcularPrazoDias(this);
    }

    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Endereco getOrigem() { return origem; }
    public Endereco getDestino() { return destino; }
    public double getPesoKg() { return pesoKg; }
    public double getDistanciaKm() { return distanciaKm; }
    public ModalidadeEntrega getModalidade() { return modalidade; }
    public StatusPedido getStatus() { return status; }
    public double getCustoEstimado() { return custoEstimado; }
    public int getPrazoEstimadoDias() { return prazoEstimadoDias; }

    @Override
    public String toString() {
        return String.format("Pedido #%d | %s | %s | R$ %.2f | %d dia(s) | %s",
                id, cliente.getNome(),
                modalidade != null ? modalidade.getNome() : "sem modalidade",
                custoEstimado, prazoEstimadoDias, status);
    }
}