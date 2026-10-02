import java.util.*;

public class Produto {

    private String nome;
    private Time time;
    private List<Sprint> sprints = new ArrayList<>();

    public Produto(String nome, Time time) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do produto não pode ser vazio.");
        }
        if (time == null) {
            throw new IllegalArgumentException("Time não pode ser nulo.");
        }
        this.nome = nome;
        this.time = time;
    }

    public Produto(String nome, Time time, List<Sprint> sprints) {
        this(nome, time);
        if (sprints != null) {
            sprints.forEach(this::addSprint);
        }
    }

    public Produto(String nome, Time time, Sprint[] sprints) {
        this(nome, time);
        if (sprints != null) {
            for (Sprint sprint : sprints) {
                addSprint(sprint);
            }
        }
    }

    public String getName() {
        return getNome();
    }

    public String getNome() {
        return nome;
    }

    public Time getTime() {
        return time;
    }

    public List<Sprint> getSprints() {
        return Collections.unmodifiableList(sprints);
    }

    public Sprint[] getSprintsArray() {
        return sprints.toArray(Sprint[]::new);
    }

    public Sprint getSprint(String id) {
        return sprints.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addSprint(Sprint sprint) {
        if (sprint == null) {
            throw new IllegalArgumentException("Sprint não pode ser nula.");
        }
        if (sprint.getProduto() != this) {
            throw new IllegalArgumentException("A Sprint pertence a outro produto.");
        }
        if (getSprint(sprint.getId()) != null) {
            throw new IllegalArgumentException("Já existe uma Sprint com o id informado.");
        }
        sprints.add(sprint);
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj instanceof Produto other && nome.equals(other.nome));
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", time=" + time +
                ", sprints=" + sprints.size() +
                '}';
    }
}
