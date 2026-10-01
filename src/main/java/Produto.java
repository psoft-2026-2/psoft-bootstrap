import java.util.List;

public class Produto {

    private String nome;
    private Time time;
    private List<Sprint> sprints;

    public Produto(String nome, Time time, List<Sprint> sprints) {
        this.nome = nome;
        this.time = time;
        this.sprints = sprints;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novo) {
        this.nome = novo;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time novo) {
        this.time = novo;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(List<Sprint> novas) {
        this.sprints = novas;
    }

    public void addSprint(Sprint nova) {
        sprints.add(nova);
    }

    public void removeSprint(Sprint sprint) {
        sprints.remove(sprint);
    }
}
