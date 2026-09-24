public class Pagamento {
    private int id;
    private int idUsuario;
    private float valor;
    private StatusPagamento status;

    public Pagamento(int id, int idUsuario, float valor, StatusPagamento status) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.valor = valor;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public float getValor() {
        return valor;
    }

    public StatusPagamento getStatus() {
        return status;
    }
}