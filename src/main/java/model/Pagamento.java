package model;
import java.util.Date;

public class Pagamento {

    private int idPagamento;
    private Date dataPagamento;
    private double valorTotal;
    private double valorRecebido;

    public Pagamento(int idPagamento, double valorTotal, double valorRecebido) {
        this.idPagamento = idPagamento;
        this.dataPagamento = new Date();
        this.valorTotal = valorTotal;
        this.valorRecebido = valorRecebido;
    }

    public boolean realizarPagamento() {
        return valorRecebido >= valorTotal;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getValorRecebido() {
        return valorRecebido;
    }
}
