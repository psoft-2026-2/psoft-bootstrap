public class Boleto implements Pagamento {
    private int cod;

    public Boleto(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    @Override
    public boolean pagar() {
        return cod > 0;
    }

    @Override
    public String toString() {
        return "Boleto{cod=" + cod + "}";
    }
}
