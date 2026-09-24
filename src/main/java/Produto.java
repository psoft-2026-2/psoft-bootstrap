public class Produto {
    private String nome;
    private String codigo;
    private float preco;

    public Produto(String nome, String codigo, float preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String newNome) {
        this.nome = newNome;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float newPreco) {
        this.preco = newPreco;
    }
}