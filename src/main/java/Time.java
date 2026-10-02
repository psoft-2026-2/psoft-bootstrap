import java.util.List;

public class Time {
    private Produto produto;
    private List<Funcionario> desenvolvedores;
    private Funcionario gerente;
    private List<Sprint> sprints;

    public Time(Produto produto, Funcionario gerente) {
        this.produto = produto;
        this.gerente = gerente;
    }

    public Produto getProduto() {
        return produto;
    }

    public List<Funcionario> getDesenvolvedores() {
        return desenvolvedores;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(Sprint sprint) {
        sprints.add(sprint);
    }

    public void setDesenvolvedores(Funcionario dev) {
        desenvolvedores.add(dev);
    }
}
