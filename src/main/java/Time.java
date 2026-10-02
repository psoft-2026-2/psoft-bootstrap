import java.util.LinkedHashMap;
import java.util.Map;

public class Time {
    private static int proximoId = 1;

    private String nome;
    private int id;
    private Funcionario gerente;
    private Map<Integer, Sprint> sprints;
    private Map<Integer, Funcionario> equipe;
    private Produto produto;

    public Time(String nome, Funcionario ger, Produto produto) {
        this.nome = nome;
        this.id = proximoId++;
        this.gerente = ger;
        this.produto = produto;
        this.sprints = new LinkedHashMap<>();
        this.equipe = new LinkedHashMap<>();
    }

    public void addSprint(int num, Funcionario lider) {
        if (sprints.containsKey(num)) {
            return;
        }

        if (!equipe.containsKey(lider.getId())) {
            return;
        }

        if (!lider.possuiFuncao(Desenvolvedor.class)) {
            return;
        }

        for (Sprint sprint : sprints.values()) {
            if (sprint.getLider().getId() == lider.getId()) {
                return;
            }
        }

        sprints.put(num, new Sprint(num, lider));
    }

    public void addFuncionario(Funcionario f) {
        if (f.possuiFuncao(Desenvolvedor.class)) {
            equipe.put(f.getId(), f);
        }
    }

    public boolean setGerente(Funcionario f) {
        if (!equipe.containsKey(f.getId())) {
            return false;
        }

        if (!f.promove()) {
            return false;
        }

        gerente = f;
        equipe.remove(f.getId());
        return true;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public Map<Integer, Sprint> getSprints() {
        return sprints;
    }

    public Map<Integer, Funcionario> getEquipe() {
        return equipe;
    }

    public Produto getProduto() {
        return produto;
    }
}
