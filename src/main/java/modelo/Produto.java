package modelo;

public class Produto {
    private final String id;
    private String nome;
    private String descricao;
    private Time timeResponsavel;

    public Produto(String id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.timeResponsavel = null;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Time getTimeResponsavel() {
        return timeResponsavel;
    }

    public void setTimeResponsavel(Time time) {
        this.timeResponsavel = time;
    }
}