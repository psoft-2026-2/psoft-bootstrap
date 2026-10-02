public class Produto {
    private String nome;
    private int cod;

    public Produto(String nome, int cod) {
        this.nome = nome;
        this.cod = cod;
    }

    public String getNome() { return nome; }
    public int getCod() { return cod; }

    @Override
    public String toString() {
        return "Produto " + nome + " (cod: " + cod + ")";
    }
}