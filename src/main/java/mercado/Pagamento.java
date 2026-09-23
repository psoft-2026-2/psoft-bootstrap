package mercado;

public class Pagamento {

    private float valor;
    private String tipo;

    public Pagamento(float valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}