
import java.time.LocalDateTime;

public class Pagamento {
    private double valor;
    private LocalDateTime dataHora;

    public Pagamento(double valor) { 
        this.valor = valor; 
        this.dataHora = LocalDateTime.now(); 
    } 
    
    public double getValor() { 
        return valor; 
    } 
    
    public LocalDateTime getDataHora() { 
        return dataHora; 
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
