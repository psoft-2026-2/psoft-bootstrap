import java.util.Date;

public class Pagamento {
    private double valor;
    private Date dataHora;

    public Pagamento(double valor) {
        this.valor = valor;
        this.dataHora = new Date();
    }

    public double getValor() {
        return valor;
    }

    public Date getDataHora() {
        return dataHora;
    }
}