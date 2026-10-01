import java.util.ArrayList;
import java.util.List;

public class ProdSoftware {
    private String nome;
    private List<Sprint> sprints;

    public ProdSoftware(String nome) {
        this.nome = nome;
        this.sprints = new ArrayList<>();
    }

    public void addSprint(Sprint sprint) {
        this.sprints.add(sprint);
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public String getNome() {
        return nome;
    }
}
