package logistica;

public class Pedido {

    private final String cliente;
    private final String origem;
    private final String destino;
    private final double peso;
    private final int distanciaKm;
    private ModalidadeEntrega modalidade;
    private StatusPedido status = StatusPedido.CRIADO;

    public Pedido(String cliente, String origem, String destino, double peso, int distanciaKm) {
        if (vazio(cliente) || vazio(origem) || vazio(destino)) {
            throw new IllegalArgumentException("Cliente, origem e destino são obrigatórios");
        }
        if (peso <= 0 || Double.isNaN(peso) || distanciaKm <= 0) {
            throw new IllegalArgumentException("Peso e distância devem ser positivos");
        }
        this.cliente = cliente;
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.distanciaKm = distanciaKm;
    }

    public String getCliente() {
        return cliente;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }

    public int getDistanciaKm() {
        return distanciaKm;
    }

    public ModalidadeEntrega getModalidade() {
        return modalidade;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setModalidade(ModalidadeEntrega modalidade) {
        if (modalidade == null) {
            throw new IllegalArgumentException("Modalidade de entrega é obrigatória");
        }
        if (status == StatusPedido.DESPACHADO) {
            throw new IllegalStateException("Pedido já despachado: a modalidade não pode ser alterada");
        }
        this.modalidade = modalidade;
    }

    // Visível só no pacote: quem despacha é a central de logística.
    void despachar() {
        if (modalidade == null) {
            throw new IllegalStateException("Selecione uma modalidade de entrega antes de despachar");
        }
        if (status == StatusPedido.DESPACHADO) {
            throw new IllegalStateException("Pedido já foi despachado");
        }
        status = StatusPedido.DESPACHADO;
    }

    private static boolean vazio(String texto) {
        return texto == null || texto.isBlank();
    }
}
