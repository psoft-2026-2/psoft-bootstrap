public class Pedido {

    private String nomeCliente;
    private String cpfCliente;
    private String enderecoOrigem;
    private String enderecoDestino;
    private double distanciaEstimada;
    private StatusPedido status;
    private double peso;
    private ModalidadeEntrega modalidade;

    public Pedido(String nomeCliente, String cpfCliente, String enderecoOrigem,
                  String enderecoDestino, double distanciaEstimada, double peso,
                  ModalidadeEntrega modalidade) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.distanciaEstimada = distanciaEstimada;
        this.peso = peso;
        this.modalidade = modalidade;
        this.status = StatusPedido.NAO_DESPACHADO;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void setEnderecoOrigem(String endereco) {
        this.enderecoOrigem = endereco;
    }

    public void setModalidade(ModalidadeEntrega modalidade) {
        if (status == StatusPedido.DESPACHADO) {
            throw new IllegalStateException("Não é possível alterar a modalidade de um pedido já despachado.");
        }
        this.modalidade = modalidade;
    }

    public ModalidadeEntrega getModalidade() {
        return modalidade;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public double getDistanciaEstimada() {
        return distanciaEstimada;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Pedido de " + nomeCliente + " (" + enderecoOrigem + " -> " + enderecoDestino
                + ", " + distanciaEstimada + " km, " + peso + " kg, modalidade " + modalidade
                + ", " + status + ")";
    }
}
