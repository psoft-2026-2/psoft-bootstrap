import java.util.List;
public class Time {
    private String nomeTime;
    private List<Funcionario> desenvolvedores;
    private Funcionario gerente;
    private Produto produto;
    private List<Sprint> sprints;

    public Time(String nomeTime, List<Funcionario> desenvolvedores, Funcionario gerente, Produto produto,
            List<Sprint> sprints) {
        this.nomeTime = nomeTime;
        this.desenvolvedores = desenvolvedores;
        this.gerente = gerente;
        this.produto = produto;
        this.sprints = sprints;
    }

    public void addDev(Funcionario desenvolvedor) {
        this.desenvolvedores.add(desenvolvedor);
    }

    public void removeDev(Funcionario desenvolvedor) {
        this.desenvolvedores.remove(desenvolvedor);
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public List<Funcionario> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Funcionario> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public void setGerente(Funcionario gerente) {
        this.gerente = gerente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Sprint> getSprints() {
        return this.sprints;
    }

    public void addSprint(Sprint sprint) {
        this.sprints.add(sprint);
    }

    public void setSprints(List<Sprint> sprints) {
        this.sprints = sprints;
    }
    
}
