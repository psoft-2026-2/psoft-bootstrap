public class Produto {
    private String nome;
    
    public Produto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Produto: " + this.nome;
    }
}
