import java.util.ArrayList;
import java.util.List;

public class CicloDesenvolvimento {
    private String nome;
    private List<Requisito> requisitos;
    private List<Sprint> sprints;

    public CicloDesenvolvimento(String nome) {
        this.nome = nome;
        this.requisitos = new ArrayList<>();
        this.sprints = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Requisito> getRequisitos() {
        return new ArrayList<>(requisitos);
    }

    public List<Sprint> getSprints() {
        return new ArrayList<>(sprints);
    }

    public void adicionarRequisito(Requisito requisito) {
        requisitos.add(requisito);
    }

    public void adicionarSprint(Sprint sprint) {
        sprints.add(sprint);
    }
}