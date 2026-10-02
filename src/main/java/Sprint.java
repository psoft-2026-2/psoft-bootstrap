public class Sprint {
    private String nome;
    private int duracao;

    public Sprint(String nome, int duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Sprint " + nome + " (" + duracao + " dias)";
    }
}