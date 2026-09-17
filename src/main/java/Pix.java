public class Pix extends Pagamento {

    public Pix(double valor) {
        super(valor);
    }

    @Override
    public String getTipo() {
        return "PIX";
    }
}