package model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private List<Time> times;
    private List<Funcionario> funcionarios;

    public Empresa(String nome) {
        this.nome = nome;
        this.times = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarTime(Time t) {
        times.add(t);
    }

    public void adicionarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public Funcionario getProductOwner(Funcionario f) {
        for (Time t : times) {
            if (t.getMembros().contains(f)) {
                return t.getMembros().stream()
                        .filter(m -> m.possuiCargo(CargoProductOwner.class))
                        .findFirst()
                        .orElse(null);
            }
        }
        return null;
    }

    public void promoverAProductOwner(Funcionario gerente) {
        if (!gerente.possuiCargo(CargoGerente.class)) {
            throw new IllegalArgumentException("Apenas gerentes podem ser promovidos a Product Owner.");
        }
        gerente.adicionarCargo(new CargoProductOwner());
    }

    public String getNome() { return nome; }
    public List<Time> getTimes() { return new ArrayList<>(times); }
    public List<Funcionario> getFuncionarios() { return new ArrayList<>(funcionarios); }
}
