public class Pedido {

    private int id;
    private String cliente;
    private String endOrigem;
    private String endDestino;
    private double peso;
    private long distancia;
    private EntregaIF modalEntrega;
    private boolean despachado;

    public Pedido(int id, String cliente, String enderecoOrigem, String enderecoDestino, double peso, long distancia) {
        this.id = id;
        this.cliente = cliente;
        this.endOrigem = enderecoOrigem;
        this.endDestino = enderecoDestino;
        this.peso = peso;
        this.distancia = distancia;
        this.despachado = false;
    }

    public double calcularCusto() {
        if (modalEntrega != null) {
            return modalEntrega.calcularCusto(this);
        }
        return 0;
    }

    public double calcularPrazo() {
        if (modalEntrega == null) {
            return modalEntrega.calcularPrazoEntrega(this);
        }
        return 0;
    }

    public void setModalidadeEntrega(EntregaIF modalidade) {
        if (modalidade == null && !despachado) {
            this.modalEntrega = modalidade;
        }
    }

    public void despacharPedido() {
        if (modalEntrega != null) {
            this.despachado = true;
        }
    }

    public int getId() {
        return this.id;
    }

    public String getCliente() {
        return this.cliente;
    }

    public String getEndOrigem() {
        return this.endOrigem;
    }

    public String getEndDestino() {
        return this.endDestino;
    }

    public double getPeso() {
        return this.peso;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public EntregaIF getModalEntrega() {
        return this.modalEntrega;
    }

    public void setModalEntrega() {

    }

}