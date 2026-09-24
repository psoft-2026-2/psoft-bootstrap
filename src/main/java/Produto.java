public class Produto {
    private String idProduto;
    private float preco;
    private int estoque;

    public Produto(String idProduto, float preco, int estoque) {
        this.idProduto = idProduto;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public boolean validaEstoque() {
        return estoque > 0;
    }

    public String toString() {
        return "Produto{idProduto='" + idProduto + "', preco=" + preco + ", estoque=" + estoque + "}";
    }
}
