public class PIX implements Pagamento {
    private String banco;

    public PIX(String banco) { this.banco = banco; }
    public String getBanco() { return banco; }

    @Override
    public boolean pagar() {
        return banco != null && !banco.isBlank();
    }

    @Override
    public String toString() { return "PIX{banco='" + banco + "'}"; }
}
