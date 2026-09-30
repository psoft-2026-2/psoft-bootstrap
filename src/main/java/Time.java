import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Time {
    private String id;
    private String nome;
    private Produto produto;
    private Funcionario gerente;
    private Map<String, Funcionario> equipe;
    private List<Sprint> sprints;

    public Time(String id, String nome, Produto prod, Funcionario gerente) {
        if (!gerente.possuiPapel("Gerente")) {
            throw new IllegalArgumentException("O gerente do time deve ter o papel Gerente.");
        }
        this.id = id;
        this.nome = nome;
        this.produto = prod;
        this.gerente = gerente;
        this.equipe = new LinkedHashMap<>();
        this.equipe.put(gerente.getId(), gerente);
        this.sprints = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public Map<String, Funcionario> getEquipe() {
        return new LinkedHashMap<>(equipe);
    }

    public List<Sprint> getSprints() {
        return new ArrayList<>(sprints);
    }

    public boolean adicionarFuncionario(Funcionario f) {
        if (equipe.containsKey(f.getId()) || !f.possuiPapel("Desenvolvedor")) {
            return false;
        }
        equipe.put(f.getId(), f);
        return true;
    }

    public boolean iniciarSprint(int num, Funcionario lider) {
        if (equipe.get(lider.getId()) != lider) {
            return false;
        }
        if (!lider.possuiPapel("Desenvolvedor")) {
            return false;
        }
        if (!sprints.isEmpty()) {
            Sprint anterior = sprints.get(sprints.size() - 1);
            if (!anterior.isEncerrada() || anterior.getLider() == lider) {
                return false;
            }
        }
        sprints.add(new Sprint(num, lider));
        return true;
    }
}
