package sprint;

public class Produto {
    private String id;
    private String nome;
    private String descricao;
    private Time timeResponsavel;

    public Produto(String id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() { return nome; }
    public Time getTimeResponsavel() { return timeResponsavel; }
    public void setTimeResponsavel(Time t) { this.timeResponsavel = t; }

    @Override
    public String toString() {
        return "Produto: " + nome;
    }
}
