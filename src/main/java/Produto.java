public class Produto {

    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        if (preco < 0)
            throw new IllegalArgumentException("Preço não pode ser negativo");

        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {return id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public double getPreco() {return preco;}

    public void setPreco(double preco) {
        if (preco < 0)
            throw new IllegalArgumentException("Preço não pode ser negativo");
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("Produto [id=%d, nome=%s, preco=R$ %.2f]", id, nome, preco);
    }

    @Override
    public int hashCode() {return Integer.hashCode(id);}

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        return id == other.id;
    }
}
