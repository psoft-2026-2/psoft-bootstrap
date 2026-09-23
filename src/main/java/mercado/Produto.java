package mercado;

public class Produto {

    private String codigo;
    private float preco;

    public Produto(String codigo, float preco) {
        this.codigo = codigo;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}