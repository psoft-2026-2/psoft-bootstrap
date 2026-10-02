import java.util.*;

public class Time {
    private List<Pessoa> devs;
    private Pessoa gerente;
    private List<Sprint> sprints;
    private Produto produto;

    public Time() {
        this.devs = new ArrayList<>();
        this.sprints = new ArrayList<>();
    }

    public Time(String nomeGerente) {
        this.gerente = new Pessoa(nomeGerente, "gerente");
        this.devs = new ArrayList<>();
        this.sprints = new ArrayList<>();
    }

    public void cadastrarDev(String nome, String cargo) {
        devs.add(new Pessoa(nome, cargo));
    }

    public boolean removerDev(String nome) {
        for (Pessoa d : devs) {
            if (d.getNome().equals(nome)) {
                return devs.remove(d);
            }
        }
        return false;
    }

    public void atribuirGerente(String nome) {
        this.gerente = new Pessoa(nome, "gerente");
    }

    public boolean promoverGerente(String nome) {
        for (Pessoa d : devs) {
            if (d.getNome().equals(nome)) {
                d.setCargo("gerente");
                this.gerente = d;
                return devs.remove(d);
            }
        }
        return false;
    }

    public void adicionarSprint(String titulo, String dataInicio, String dataFim, String nomeLider) {
        Pessoa lider = buscarDev(nomeLider);
        sprints.add(new Sprint(lider, dataInicio, dataFim, titulo));
    }

    public void definirProduto(String nome, int id) {
        this.produto = new Produto(nome, id);
    }

    public Pessoa buscarDev(String nome) {
        for (Pessoa d : devs) {
            if (d.getNome().equals(nome)) {
                return d;
            }
        }
        return null;
    }

    public List<Pessoa> getDevs() {
        return devs;
    }

    public Pessoa getGerente() {
        return gerente;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public Produto getProduto() {
        return produto;
    }
}
