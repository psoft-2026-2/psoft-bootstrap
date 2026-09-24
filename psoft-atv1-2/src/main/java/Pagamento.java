public class Pagamento {

    private String tipo;
    private double valor;
    private StatusPagamento status;

    public Pagamento(String tipo, double valor, StatusPagamento status) {
        this.tipo = tipo;
        this.valor = valor;
        this.status = status;
    }

    public StatusPagamento getStatus() {
        return status;
    }
    
}