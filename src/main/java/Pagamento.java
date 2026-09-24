import java.time.LocalDateTime;

public class Pagamento {
    private static long proximoID = 1;

    private long idPagamento;
    private double valor;
    private FormaDePagamento formaPagamento;
    private LocalDateTime dataHora;

    public Pagamento(double valor, FormaDePagamento formaPagamento) {
        this.idPagamento = proximoID++;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.dataHora = LocalDateTime.now();
    }

    public double getValor() {
        return valor;
    }

    public FormaDePagamento getFormaPagamento() {
        return formaPagamento;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idPagamento ^ (idPagamento >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pagamento other = (Pagamento) obj;
        if (idPagamento != other.idPagamento)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pagamento: " + "\n" +
           "  id: " + idPagamento + ",\n" +
           "  forma: " + formaPagamento.toString() + ",\n" +
           "  valor: " + valor + ",\n" +
           "  dataHora: " + dataHora + "\n";
    } 
}
