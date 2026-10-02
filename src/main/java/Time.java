import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Time {
    private String nome;
    private Produto produto;
    private Funcionario gerente;
    private List<Funcionario> devs;
    private List<Sprint> sprints;

    public Time(String nome) {
        this.nome = nome;
        this.devs = new ArrayList<>();
        this.sprints = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String newNome) {
        this.nome = newNome;
    }

    public void setProduto(Produto prod) {
        this.produto = prod;
    }

    public void promoverAGerente(Funcionario func) {
        this.gerente = func;
        if (func != null) {
            func.addPapel(new Gerente());
        }
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public void delegarLiderança(Funcionario func, Sprint sp) {
        if (sp != null) {
            sp.setLider(func);
        }
        if (func != null) {
            func.addPapel(new Lider());
        }
    }

    public void addDev(Funcionario func) {
        this.devs.add(func);
        if (func != null) {
            func.addPapel(new DesenvolvedorNormal());
        }
    }

    public Funcionario getDev(Integer id) {
        if (id != null && id >= 0 && id < devs.size()) {
            return devs.get(id);
        }
        return null;
    }

    public void addSprint() {
        this.sprints.add(new Sprint(new Date()));
    }

    public Sprint getSprint(Integer id) {
        if (id != null && id >= 0 && id < sprints.size()) {
            return sprints.get(id);
        }
        return null;
    }
}
