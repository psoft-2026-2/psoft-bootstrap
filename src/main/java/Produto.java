public class Produto {
    private String nome;
    private int id;

    public Produto() {
    }

    public Produto(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}