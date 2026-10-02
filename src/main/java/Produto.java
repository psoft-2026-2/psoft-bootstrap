import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Produto {
    private final String nome;
    private final Time time;
    private final List<Sprint> sprints;

    public Produto(String nome, Time time) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome deve ser informado.");
        }
        this.nome = nome;
        this.time = Objects.requireNonNull(time, "O time deve ser informado.");
        this.sprints = new ArrayList<>();
    }

    public void adicionaSprint(Pessoa pessoa, String duracao) {
        if (!time.getPessoas().contains(pessoa)) {
            throw new IllegalArgumentException("O lider deve ser um desenvolvedor do time.");
        }
        if (duracao == null || duracao.trim().isEmpty()) {
            throw new IllegalArgumentException("A duracao deve ser informada.");
        }
        Sprint anterior = sprints.isEmpty() ? null : sprints.get(sprints.size() - 1);
        if (anterior != null && anterior.getLider() == pessoa) {
            throw new IllegalArgumentException("Sprints consecutivas devem ter lideres diferentes.");
        }
        Sprint sprint = new Sprint(sprints.size() + 1, pessoa, duracao);
        if (anterior != null && anterior.getLider().getPapel() instanceof Lider) {
            anterior.getLider().updatePapel(null);
        }
        sprints.add(sprint);
    }

    public Time getTime() {
        return time;
    }

    public String getNome() {
        return nome;
    }

    public List<Sprint> getSprints() {
        return Collections.unmodifiableList(new ArrayList<>(sprints));
    }
}