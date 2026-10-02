package model;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private int id;
    private String nome;
    private List<Cargo> cargos;

    public Funcionario(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.cargos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Cargo> getCargos() {
        return new ArrayList<>(cargos);
    }

    public void adicionarCargo(Cargo c) {
        if (c != null && !possuiCargo(c.getClass())) {
            cargos.add(c);
        }
    }

    public void removerCargo(Cargo c) {
        if (c != null) {
            cargos.removeIf(x -> x.getClass().equals(c.getClass()));
        }
    }

    public boolean possuiCargo() {
        return !cargos.isEmpty();
    }

    public boolean possuiCargo(Class<? extends Cargo> tipo) {
        return cargos.stream().anyMatch(c -> c.getClass().equals(tipo));
    }

    @Override
    public String toString() {
        return nome;
    }
}

