public class Produto {
    private String nome;
    private int id;
    private double preco;

    public Produto(String nome, int id, double preco) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    @Override 
    public String toString() {
        return "Produto: " + this.nome + ", id: " + this.id + ", preço: R$" + this.preco;
    }
}
