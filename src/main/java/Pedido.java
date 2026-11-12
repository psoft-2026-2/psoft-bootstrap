
public class Pedido {

    private String cliente;
    private String origem;
    private String destino;
    private double peso;
    private double distancia;
    private ModalidadeEntrega modalidade;
    private boolean despachado;

    public Pedido(String cliente, String origem, String destino,
                  double peso, double distancia,
                  ModalidadeEntrega modalidade) {
        if (cliente == null || cliente.isBlank()
                || origem == null || origem.isBlank()
                || destino == null || destino.isBlank()
                || peso <= 0 || distancia < 0
                || modalidade == null) {
            throw new IllegalArgumentException("Dados do pedido invalidos.");
        }

        this.cliente = cliente;
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.distancia = distancia;
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
            throw new IllegalStateException(
                "Nao e possivel alterar um pedido despachado."
            );
        }

        if (modalidade == null) {
            throw new IllegalArgumentException(
                "A modalidade nao pode ser nula."
            );
        }

        this.modalidade = modalidade;
    }

    public void despachar() {
        if (despachado) {
            throw new IllegalStateException(
                "O pedido ja foi despachado."
            );
        }

        despachado = true;
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

    public double getDistancia() {
        return distancia;
    }

    public ModalidadeEntrega getModalidade() {
        return modalidade;
    }

    public boolean isDespachado() {
        return despachado;
    }
}

