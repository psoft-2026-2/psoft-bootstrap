import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public final class Sprint {
    private final int numero;
    private final LocalDate inicio;
    private final LocalDate fim;
    private final Time time;
    private Funcionario lider;
    private boolean encerrada;

    public Sprint(int numero, LocalDate inicio, LocalDate fim, Time time, Funcionario lider) {
        if (numero <= 0) {
            throw new IllegalArgumentException("O número da Sprint deve ser positivo.");
        }
        this.inicio = Objects.requireNonNull(inicio, "Data inicial obrigatória.");
        this.fim = Objects.requireNonNull(fim, "Data final obrigatória.");
        if (fim.isBefore(inicio)) {
            throw new IllegalArgumentException("O fim da Sprint não pode ser anterior ao início.");
        }
        this.numero = numero;
        this.time = Objects.requireNonNull(time, "Time obrigatório.");
        time.registrarSprint(this, lider);
    }

    public int getNumero() {
        return numero;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public Time getTime() {
        return time;
    }

    public Funcionario getLider() {
        return lider;
    }

    public List<Funcionario> getDesenvolvedores() {
        return time.getDesenvolvedores();
    }

    public boolean isEncerrada() {
        return encerrada;
    }

    public void definirLider(Funcionario funcionario) {
        if (encerrada || time.getSprintAtual() != this) {
            throw new IllegalStateException("Só é possível definir o líder da Sprint atual e aberta.");
        }
        time.validarLider(this, funcionario);
        if (lider == funcionario) {
            return;
        }
        if (lider != null) {
            lider.retirarLideranca();
        }
        lider = funcionario;
        lider.adicionarPapel(new PapelLider());
    }

    public void encerrar() {
        if (!encerrada) {
            encerrada = true;
            lider.retirarLideranca();
        }
    }
}
