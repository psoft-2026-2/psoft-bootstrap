//Context do Strategy
public class Pedido {

    private int id;
    private Cliente cliente;
    private String endOrigem;
    private String endDestino;
    private double peso;
    private double distanciaEstimada;
    private ModalidadeEntrega modalidade;
    private boolean despachado;

    public Pedido(int id, Cliente cliente, String endOrigem, String endDestino,
                  double peso, double distanciaEstimada, ModalidadeEntrega modalidade) {
        if (cliente == null || modalidade == null) {
            throw new IllegalArgumentException("Cliente e modalidade são obrigatórios");
        }
        if (peso <= 0 || distanciaEstimada <= 0) {
            throw new IllegalArgumentException("Peso e distância devem ser positivos");
        }
        this.id = id;
        this.cliente = cliente;
        this.endOrigem = endOrigem;
        this.endDestino = endDestino;
        this.peso = peso;
        this.distanciaEstimada = distanciaEstimada;
        this.modalidade = modalidade;
        this.despachado = false;
    }

    public double calcularCusto() {
        return modalidade.calcularCusto(this);
    }

    public int calcularPrazo() {
        return modalidade.calcularPrazo(this);
    }

    public void setModalidade(ModalidadeEntrega modalidade) {
        if (despachado) {
            throw new IllegalStateException("Pedido " + id + " já foi despachado");
        }
        if (modalidade == null) {
            throw new IllegalArgumentException("Modalidade é obrigatória");
        }
        this.modalidade = modalidade;
    }

    public void despachar() {
        if (despachado) {
            throw new IllegalStateException("Pedido " + id + " já foi despachado");
        }
        this.despachado = true;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getEndOrigem() {
        return endOrigem;
    }

    public String getEndDestino() {
        return endDestino;
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

    @Override
    public String toString() {
        return String.format("Pedido #%d | %s | %s -> %s | %.1f kg, %.0f km | %s | R$ %.2f em %d dia(s) | %s",
                id, cliente.getNome(), endOrigem, endDestino, peso, distanciaEstimada,
                modalidade.getNome(), calcularCusto(), calcularPrazo(),
                despachado ? "DESPACHADO" : "aguardando despacho");
    }
}
