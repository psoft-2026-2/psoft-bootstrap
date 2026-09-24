import java.time.LocalDateTime;

public class Pagamento {
    private String id;
    private double valorTotal;
    private LocalDateTime dataHora;
    private boolean confirmado;

    public Pagamento(String id, double valorTotal) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.dataHora = LocalDateTime.now();
        this.confirmado = false;
    }

    public void processarPagamento() {
        this.confirmado = true;
    }

    public String getId() {
        return id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public boolean isConfirmado() {
        return confirmado;
    }
}