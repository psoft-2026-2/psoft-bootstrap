import java.util.Objects;

public final class Pedido {
    private final String cliente;
    private final String enderecoOrigem;
    private final String enderecoDestino;
    private final double peso;
    private final double distanciaEstimada;
    private final Entrega entrega;

    public Pedido(String cliente, String enderecoOrigem, String enderecoDestino, double peso,
                  double distanciaEstimada, ModalidadeEntrega modalidade) {
        this.cliente = Objects.requireNonNull(cliente);
        this.enderecoOrigem = Objects.requireNonNull(enderecoOrigem);
        this.enderecoDestino = Objects.requireNonNull(enderecoDestino);
        if (peso < 0 || distanciaEstimada < 0 || !Double.isFinite(peso) || !Double.isFinite(distanciaEstimada)) {
            throw new IllegalArgumentException("Peso e distância devem ser não negativos e finitos");
        }
        this.peso = peso;
        this.distanciaEstimada = distanciaEstimada;
        this.entrega = new Entrega(modalidade);
    }

    public String getCliente() { return cliente; }
    public String getEnderecoOrigem() { return enderecoOrigem; }
    public String getEnderecoDestino() { return enderecoDestino; }
    public double getPeso() { return peso; }
    public double getDistanciaEstimada() { return distanciaEstimada; }
    public Entrega getEntrega() { return entrega; }

    public void alterarModalidade(ModalidadeEntrega modalidade) {
        entrega.alterarModalidade(modalidade);
    }

    public void despachar() {
        entrega.despachar();
    }
}
