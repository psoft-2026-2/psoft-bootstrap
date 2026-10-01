import java.util.*;

public class Time {
    private List<Pessoa> devs = new ArrayList<>();
    private Pessoa gerente;
    private List<Sprint> sprints = new ArrayList<>();
    private Produto produto;

    public Time() {
    }

    public Time(Pessoa gerente) {
        this.devs = new ArrayList<>();
        this.gerente = gerente;
        this.sprints = new ArrayList<>();
        this.produto = new ArrayList<>();
    }

    public void cadastrarDev(Pessoa pessoa) {
        devs.add(pessoa);
    }

    public boolean removerDev(Pessoa pessoa) {
        return devs.remove(pessoa);
    }

    public void atribuirGerente(Pessoa gerente) {
        this.gerente = gerente;
    }

    public void adicionarSprint(Sprint sprint) {
        sprints.add(sprint);
    }
}