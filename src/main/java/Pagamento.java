public class Pagamento {
    private float valor;
    private String tipo;

    public Pagamento(float valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public float getValor() { return valor; }
    public String getTipo() { return tipo; }

    public String pagar() {
        return "Pagamento de R$" + valor + " realizado com sucesso via " + tipo;
    }
}