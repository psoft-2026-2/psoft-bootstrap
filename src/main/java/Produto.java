public class Produto {
    private int idProduto;
    private float preco;
    private String nome;

    public Produto(int idProduto, float preco, String nome) {
        this.idProduto = idProduto;
        this.preco = preco;
        this.nome = nome;
    }

    public int getId() {
        return idProduto;
    }

    public float getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}
