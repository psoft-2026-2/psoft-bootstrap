

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Time {

    private Funcionario gerente;
    private List<Funcionario> desenvolvedores = new ArrayList<>();

    public Time(Funcionario gerente) {
        definirGerente(gerente);
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public void definirGerente(Funcionario gerente) {
        if (gerente == null) {
            throw new IllegalArgumentException("Gerente não pode ser nulo.");
        }
        if (!gerente.isGerente()) {
            throw new IllegalArgumentException("O funcionário informado deve ter cargo de gerente.");
        }
        this.gerente = gerente;
        desenvolvedores.remove(gerente);
    }

    public List<Funcionario> getDesenvolvedores() {
        return Collections.unmodifiableList(desenvolvedores);
    }

    public Funcionario getGerenteTime() {
        return getGerente();
    }

    public List<Funcionario> getDev() {
        return getDesenvolvedores();
    }

    public Funcionario[] getDevArray() {
        return desenvolvedores.toArray(Funcionario[]::new);
    }

    public void promoverParaGerente(Funcionario desenvolvedor) {
        if (!possuiDesenvolvedor(desenvolvedor)) {
            throw new IllegalArgumentException("O funcionário não é desenvolvedor deste time.");
        }
        desenvolvedor.promoverParaGerente();
        desenvolvedores.remove(desenvolvedor);
        definirGerente(desenvolvedor);
    }

    public void addDesenvolvedor(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Desenvolvedor não pode ser nulo.");
        }
        if (!funcionario.isDesenvolvedor()) {
            throw new IllegalArgumentException("Somente funcionários com cargo de desenvolvedor podem ser adicionados ao time.");
        }
        if (funcionario.equals(gerente)) {
            throw new IllegalArgumentException("O gerente não pode ser desenvolvedor do mesmo time.");
        }
        if (!desenvolvedores.contains(funcionario)) {
            desenvolvedores.add(funcionario);
        }
    }

    public void removerDesenvolvedor(Funcionario funcionario) {
        desenvolvedores.remove(funcionario);
    }

    public boolean possuiDesenvolvedor(Funcionario funcionario) {
        return desenvolvedores.contains(funcionario);
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj instanceof Time other
                && Objects.equals(gerente, other.gerente)
                && Objects.equals(desenvolvedores, other.desenvolvedores));
    }

    @Override
    public int hashCode() {
        return Objects.hash(gerente, desenvolvedores);
    }

    @Override
    public String toString() {
        return "Time{" +
                "gerente=" + gerente +
                ", desenvolvedores=" + desenvolvedores +
                '}';
    }
}
