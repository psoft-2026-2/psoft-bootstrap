package modelo;

import java.util.ArrayList;
import java.util.List;

public class Time {
    private final String id;
    private String nome;
    private Produto produto;
    private Funcionario gerente;
    private final List<Funcionario> desenvolvedores;
    private final List<Sprint> sprints;

    public Time(String id, String nome, Produto produto, Funcionario gerente) {
        this.id = id;
        this.nome = nome;
        this.produto = produto;
        this.gerente = gerente;
        this.desenvolvedores = new ArrayList<>();
        this.sprints = new ArrayList<>();

        if (produto != null) {
            produto.setTimeResponsavel(this);
        }
        if (gerente != null) {
            gerente.setFuncaoAtual(new funcao.Gerente());
        }
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        if (produto != null) {
            produto.setTimeResponsavel(this);
        }
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public void setGerente(Funcionario gerente) {
        this.gerente = gerente;
        if (gerente != null) {
            gerente.setFuncaoAtual(new funcao.Gerente());
        }
    }

    public List<Funcionario> getDesenvolvedores() {
        return new ArrayList<>(desenvolvedores);
    }

    public void adicionarDesenvolvedor(Funcionario dev) {
        if (!desenvolvedores.contains(dev) && dev.ehDev()) {
            desenvolvedores.add(dev);
        }
    }

    public void removerDesenvolvedor(Funcionario dev) {
        desenvolvedores.remove(dev);
        if (dev.ehLider()) {
            dev.renunciarLideranca();
        }
    }

    public List<Sprint> getSprints() {
        return new ArrayList<>(sprints);
    }

    public void adicionarSprint(Sprint sprint) {
        sprints.add(sprint);
    }

    public Sprint getSprintAtual() {
        for (Sprint sprint : sprints) {
            if (sprint.getStatus() == StatusSprint.EM_ANDAMENTO) {
                return sprint;
            }
        }
        return null;
    }

    public void promoverDesenvolvedorAGerente(Funcionario dev) {
        if (desenvolvedores.contains(dev) && dev.ehDev() && gerente == null) {
            dev.promoverAGerente();
            this.gerente = dev;
            removerDesenvolvedor(dev);
        }
    }

    public List<Funcionario> getTodosMembros() {
        List<Funcionario> todos = new ArrayList<>();
        if (gerente != null) {
            todos.add(gerente);
        }
        todos.addAll(desenvolvedores);
        return todos;
    }
}