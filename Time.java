import java.util.ArrayList;
import java.util.List;

public class Time {
    private Funcionario gerente;
    private List<Funcionario> desenvolvedores = new ArrayList<>();
    private Produto produto;
    private List<Sprint> sprints = new ArrayList<>();

    public Time(Produto produto) {
        this.produto = produto;
    }

    public void adicionarDesenvolvedor(Funcionario dev) {
        desenvolvedores.add(dev);
    }

    public void promoverGerente(Funcionario dev) {
        dev.promover(new Gerente());
        desenvolvedores.remove(dev);
        gerente = dev;
    }

    public Sprint iniciarSprint() {
        int numero = sprints.size() + 1;
        Funcionario lider = desenvolvedores.get(sprints.size() % desenvolvedores.size());
        Sprint sprint = new Sprint(numero, lider);
        sprint.iniciar();
        sprints.add(sprint);
        return sprint;
    }

    public Funcionario getGerente() {
        return gerente;
    }
}