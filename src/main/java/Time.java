import java.util.ArrayList;
import java.util.List;

public class Time {
    private String nome;
    private Produto produto;
    private Funcionario gerente;
    private List<Funcionario> desenvolvedores;
    private List<Sprint> sprints;

    public Time(String nome, Produto produto, Funcionario gerente) {
        if (gerente.getPapel() != Papel.GERENTE) {
            throw new IllegalArgumentException("O time deve possuir um gerente.");
        }
        this.nome = nome;
        this.produto = produto;
        this.gerente = gerente;
        this.desenvolvedores = new ArrayList<>();
        this.sprints = new ArrayList<>();
    }

    public void adicionarDesenvolvedor(Funcionario dev) {
        if (dev.getPapel() != Papel.DESENVOLVEDOR) {
            throw new IllegalArgumentException("Funcionario precisa ser desenvolvedor.");
        }
        this.desenvolvedores.add(dev);
    }

    public void iniciarSprint(int numero, Funcionario lider) {
        if (!this.desenvolvedores.contains(lider)) {
            throw new IllegalArgumentException("O lider precisa ser desenvolvedor do time.");
        }

        for (Funcionario dev : this.desenvolvedores) {
            dev.setEhLider(false);
        }

        Sprint sprint = new Sprint(numero, lider);
        this.sprints.add(sprint);
    }

    public String getNome() {
        return this.nome;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public Funcionario getGerente() {
        return this.gerente;
    }

    public List<Funcionario> getDesenvolvedores() {
        return this.desenvolvedores;
    }

    public List<Sprint> getSprints() {
        return this.sprints;
    }
}