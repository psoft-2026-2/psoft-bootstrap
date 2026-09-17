public class Cartao {

    private int numero;
    private int cvv;
    private String validade;

    public Cartao(int numero, int cvv, String validade) {
        this.numero = numero;
        this.cvv = cvv;
        this.validade = validade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
}