import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Time {

    private String id;
    private String nome;
    private Funcionario gerente;
    private Map<String, Funcionario> equipe = new HashMap<>();
    private List<Sprint> sprints = new ArrayList<>();
    private Produto produto;

    public Time(String id, String nome, Funcionario g) {
        this.id = id;
        this.nome = nome;
        mudarGerente(g);
    }

    public void adicionarSprint(String n, Funcionario l) {
        if (!equipe.containsKey(l.getId())) {
            throw new IllegalArgumentException("O líder deve ser membro da equipe");
        }
        sprints.add(new Sprint(n, l));
    }

    public void adicionarMembro(Funcionario f) {
        if (!f.possuiPapel(Dev.class)) {
            throw new IllegalArgumentException("Apenas desenvolvedores podem integrar a equipe");
        }
        equipe.put(f.getId(), f);
    }

    public void mudarGerente(Funcionario f) {
        f.promover(new Gerente(this));
        this.gerente = f;
    }

    public void atribuirProduto(Produto p) {
        this.produto = p;
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
        return new HashMap<>(equipe);
    }

    public List<Sprint> getSprints() {
        return new ArrayList<>(sprints);
    }

    public Produto getProduto() {
        return produto;
    }
}
