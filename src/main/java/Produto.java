public class Produto {
    private String nome;
    private double preco;
    private String idProduto;

    public Produto(String nome, double preco, String id) {
        this.nome = nome;
        this.preco = preco;
        this.idProduto = id;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return idProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void updatePreco(double preco) {
        this.preco = preco;
    }
}
