package mercado;

import java.time.LocalDateTime;

public class Pagamento {
    private double valorPago;
    private LocalDateTime dataHora;
    private boolean confirmado;

    public Pagamento(double valorPago) {
        this.valorPago = valorPago;
        this.dataHora = LocalDateTime.now();
        this.confirmado = true;
    }

    public double getValorPago() {
        return valorPago;
    }

    public boolean isConfirmado() {
        return confirmado;
    }
}