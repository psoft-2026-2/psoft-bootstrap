public class Pagamento {

    private double valor;
    private String tipo;
    private String descricao;

    public Pagamento(double valor, String tipo, String descricao) {
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }
}