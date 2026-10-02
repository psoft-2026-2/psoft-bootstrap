import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Time {

    private final Funcionario gerente;
    private final List<Funcionario> desenvolvedores;

    public Time(Funcionario gerente) {

        if (gerente == null || !gerente.ehGerente()) {
            throw new IllegalArgumentException(
                    "O gerente do time deve ser um funcionário com cargo de Gerente."
            );
        }

        this.gerente = gerente;
        this.desenvolvedores = new ArrayList<>();
    }

    public void addDesenvolvedor(Funcionario dev) {

        if (dev == null || !dev.ehDesenvolvedor()) {
            throw new IllegalArgumentException(
                    "Apenas desenvolvedores podem entrar no time."
            );
        }

        if (desenvolvedores.contains(dev)) {
            throw new IllegalArgumentException(
                    "O desenvolvedor já pertence ao time."
            );
        }

        desenvolvedores.add(dev);
    }

    public void removerDesenvolvedor(Funcionario dev) {
        desenvolvedores.remove(dev);
    }

    public Funcionario getGerente() {
        return this.gerente;
    }

    public List<Funcionario> getDesenvolvedores() {
        return Collections.unmodifiableList(this.desenvolvedores);
    }

    public boolean possuiDesenvolvedor(Funcionario dev) {
        return desenvolvedores.contains(dev);
    }

    @Override
    public String toString() {

        StringBuilder resultado = new StringBuilder();

        resultado.append("Gerente: ")
                .append(gerente)
                .append("\n");

        resultado.append("Desenvolvedores:\n");

        for (Funcionario dev : desenvolvedores) {
            resultado.append("- ")
                    .append(dev)
                    .append("\n");
        }

        return resultado.toString();
    }
}