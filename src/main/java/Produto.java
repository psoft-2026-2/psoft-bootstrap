public class Produto{
    private final int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
    
    public boolean setPreco(double preco) {
        if (preco < 0) {
            return false;
        }
        this.preco = preco;
        return true;
    }
    
    public boolean setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            return false;
        }
        this.nome = nome;
        return true;
    }
}