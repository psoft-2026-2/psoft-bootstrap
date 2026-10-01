import java.util.ArrayList;
import java.util.List;

public class Time {
    
    private String id;
    private String nome;
    private Produto produto;
    private Pessoa gerente;
    private List<Pessoa> equipe;
    private List<Sprint> sprints;

    public Time(String id, String nome, Produto prod, Pessoa gerente) {
        if (!gerente.possuiPapel("Gerente")) {
            throw new IllegalArgumentException("O gerente do time deve ter o papel Gerente.");
        }
        this.id = id;
        this.nome = nome;
        this.produto = prod;
        this.gerente = gerente;
        this.equipe = new ArrayList<>();
        this.equipe.add(gerente); // Adiciona o gerente à equipe
        this.sprints = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa getGerente() {
        return gerente;
    }

    public List<Pessoa> getEquipe() {
        return new ArrayList<>(equipe); // Retorna uma cópia defensiva
    }

    public List<Sprint> getSprints() {
        return new ArrayList<>(sprints);
    }

    public boolean adicionarPessoa(Pessoa p) {
        if (p == null || !p.possuiPapel("Desenvolvedor") || contemPessoa(p.getId())) {
            return false;
        }
        equipe.add(p);
        return true;
    }

    public boolean iniciarSprint(int num, Pessoa lider) {
        if (lider == null || !contemPessoa(lider.getId())) {
            return false;
        }
        if (!lider.possuiPapel("Desenvolvedor")) {
            return false;
        }
        if (!sprints.isEmpty()) {
            Sprint anterior = sprints.get(sprints.size() - 1);
            if (!anterior.isEncerrada() || anterior.getLider().equals(lider)) {
                return false;
            }
        }
        sprints.add(new Sprint(num, lider));
        return true;
    }

    // Método auxiliar privado para busca de pessoas pelo ID
    private boolean contemPessoa(String id) {
        for (Pessoa p : equipe) {
            if (p.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
