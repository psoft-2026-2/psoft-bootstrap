package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Time {
    private String nome;
    private List<Funcionario> membros;   
    private Produto produto;             
    private List<Sprint> sprints;        
    private SelecaoLider selecaoLider;   

    public Time(String nome, Produto produto, SelecaoLider selecaoLider) {
        this.nome = nome;
        this.produto = produto;
        this.selecaoLider = selecaoLider;
        this.membros = new ArrayList<>();
        this.sprints = new ArrayList<>();
    }

    public void adicionarMembro(Funcionario f) {
        if (f != null && !membros.contains(f)) {
            membros.add(f);
        }
    }

    public Sprint novaSprint() {
        Funcionario lider = selecaoLider.proximo(this);
        LocalDate inicio = LocalDate.now();
        Sprint sprint = new Sprint(sprints.size() + 1, inicio, inicio.plusWeeks(2), lider);
        sprints.add(sprint);
        return sprint;
    }

    public Funcionario getGerente() {
        return membros.stream()
                .filter(f -> f.possuiCargo(CargoGerente.class))
                .findFirst()
                .orElse(null);
    }

    public void promoveGerente(Funcionario desenvolvedor) {
        if (!membros.contains(desenvolvedor)) {
            throw new IllegalArgumentException("Funcionário não pertence ao time.");
        }
        Funcionario atual = getGerente();
        if (atual != null) {
            atual.removerCargo(new CargoGerente());
        }
        desenvolvedor.adicionarCargo(new CargoGerente());
    }

    public List<Funcionario> getDesenvolvedores() {
        return membros.stream()
                .filter(f -> f.possuiCargo(CargoDesenvolvedor.class))
                .collect(Collectors.toList());
    }

    public String getNome() { return nome; }
    public Produto getProduto() { return produto; }
    public List<Funcionario> getMembros() { return new ArrayList<>(membros); }
    public List<Sprint> getSprints() { return new ArrayList<>(sprints); }
}

