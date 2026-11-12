public class Pedido {
    private final Cliente cliente;
    private final String origem;
    private final String destino;
    private final float peso;
    private final String idPedido;
    private final float distancia;
    private ModalidadeEntrega modalidade;
    private boolean despachado;
    private float custoEntrega;
    private int prazoEntrega;

    public Pedido(Cliente cliente, String origem, String destino, float peso,
                  float distancia, String idPedido) {
        this.cliente = cliente;
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.distancia = distancia;
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public float getPeso() {
        return peso;
    }

    public float getDistancia() {
        return distancia;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public boolean isDespachado() {
        return despachado;
    }

    public float getCustoEntrega() {
        return custoEntrega;
    }

    public int getPrazoEntrega() {
        return prazoEntrega;
    }

    boolean alterarModalidade(ModalidadeEntrega modalidade) {
        if (despachado || modalidade == null) {
            return false;
        }

        this.modalidade = modalidade;
        return true;
    }

    boolean despachar() {
        if (despachado || modalidade == null) {
            return false;
        }

        float custo = modalidade.calcularCusto(distancia);
        int prazo = modalidade.calcularPrazo();
        custoEntrega = custo;
        prazoEntrega = prazo;
        despachado = true;
        return true;
    }
}
