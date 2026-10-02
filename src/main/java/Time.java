package atv2;

import java.util.ArrayList;
import java.util.List;

public class Time {
    private String id;
    private Produto produto;
    private Funcionario gerente;
    private List<Funcionario> desenvolvedores;

    public Time(String id, Produto produto, Funcionario gerente) {
        this.id = id;
        this.produto = produto;
        this.desenvolvedores = new ArrayList<>();
        setGerente(gerente);
    }

    public void adicionarDesenvolvedor(Funcionario dev) {
        if (!(dev.getCargo() instanceof Desenvolvedor)) {
            throw new IllegalArgumentException("Apenas desenvolvedores entram na equipe.");
        }
        desenvolvedores.add(dev);
    }

    public void removerDesenvolvedor(Funcionario dev) {
        desenvolvedores.remove(dev);
    }

    public boolean temDesenvolvedor(Funcionario dev) {
        return desenvolvedores.contains(dev);
    }

    public void setGerente(Funcionario gerente) {
        if (!(gerente.getCargo() instanceof Gerente)) {
            throw new IllegalArgumentException("O gerente precisa ter o cargo de Gerente.");
        }
        this.gerente = gerente;
    }

    public String getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public List<Funcionario> getDesenvolvedores() {
        return desenvolvedores;
    }

    @Override
    public String toString() {
        return "Time " + id + " - produto: " + produto + ", gerente: " + gerente
                + ", devs: " + desenvolvedores;
    }
}
