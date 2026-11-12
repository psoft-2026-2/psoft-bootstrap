public class Pedido {
    private String nomeCliente;
    private String cpf;
    private String origem;
    private String destino;
    private float distanciaEst;
    private float custo;
    private Entrega entrega;
    private boolean despachado;
    private String nomePedido;

    public Pedido(String nomeCliente, String cpf, String origem, String destino,
                  float distanciaEst, float custo, String nomePedido) {
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.origem = origem;
        this.destino = destino;
        this.distanciaEst = distanciaEst;
        this.custo = custo;
        this.nomePedido = nomePedido;
    }

    public boolean despachar() {
        if (entrega == null || despachado) {
            return false;
        }
        despachado = true;
        return true;
    }

    public float getTotal() {
        return custo + entrega.getCusto(distanciaEst);
    }

    public float getTempo() {
        return entrega.getTempo(distanciaEst);
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }
}