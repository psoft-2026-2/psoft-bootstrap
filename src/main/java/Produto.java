public class Produto {
    private String nome;
    private int preco; // em centavos

    public Produto(String nome, int preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getPreco() {
        return preco;
    }

    public boolean setPreco(int newPrice) {
        if (newPrice < 0) {
            return false;
        }
        this.preco = newPrice;
        return true;
    }
}