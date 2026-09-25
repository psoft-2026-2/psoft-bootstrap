public class Cartao implements Pagamento {
    private String numero;

    public Cartao(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public boolean pagar() {
        return numero != null && !numero.isBlank();
    }

    @Override
    public String toString() {
        return "Cartao{numero='" + numero + "'}";
    }
}
