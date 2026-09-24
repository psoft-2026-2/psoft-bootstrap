public class Pagamento {
    private String tipo;
    private float valorFinal;

    public Pagamento(String tipo) {
        this.tipo = tipo;
    }

    public void paga(float valor) {
        this.valorFinal = valor;
        System.out.println("Valor " + valor + " pago via " + tipo);
    }
}
