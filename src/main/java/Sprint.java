import java.time.LocalDate;

public class Sprint {
    private int id;
    private LocalDate inicio;
    private LocalDate fim;
    private Funcionario lider;

    public Sprint(int id, LocalDate inicio, LocalDate fim) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
    }

    public int getId() {
        return id;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public Funcionario getLider() {
        return lider;
    }
}
