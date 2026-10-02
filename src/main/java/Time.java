
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {

    private String nome;
    private List<Colaborador> equipe = new ArrayList<>();
    private Colaborador gerente;
    private Produto produto;
    private List<Sprint> sprints = new ArrayList<>();

    public Time(String nome, Produto produto) {
        this.nome = nome;
        this.produto = produto;
    }

    public void adicionarColaborador(Colaborador c) {
        if (!equipe.contains(c)) {
            equipe.add(c);
        }
    }

    //apenas um colaborador Gerente pode ser colocado como gerente do time
    public void definirGerente(Colaborador colaborador) {
        if (!colaborador.temPapel(Gerente.class)) {
            throw new IllegalArgumentException(
                "O colaborador '" + colaborador.getNome() + "' nao exerce o papel de Gerente.");
        }
        adicionarColaborador(colaborador);
        this.gerente = colaborador;
    }

    /** Creator: o Time cria e guarda suas proprias Sprints. */
    public Sprint iniciarSprint(LocalDate inicio, LocalDate fim) {
        Sprint sprint = new Sprint(sprints.size() + 1, inicio, fim);
        sprints.add(sprint);
        return sprint;
    }

    public String getNome() {
        return nome;
    }

    public Produto getProduto() {
        return produto;
    }

    public Colaborador getGerente() {
        return gerente;
    }

    public List<Colaborador> getEquipe() {
        return equipe;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }
}
