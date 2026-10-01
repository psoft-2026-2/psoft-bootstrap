import java.util.ArrayList;
import java.util.List;

public class Time {
    private final Produto produto;
    private final Funcionario gerente;
    private final List<Funcionario> desenvolvedores = new ArrayList<>();
    private final Sprint sprint;
    private final List<Sprint> sprints = new ArrayList<>();
    private Funcionario liderAtual;

    public Time(Produto produto, Funcionario gerente, Sprint sprint) {
        this.produto = produto; this.gerente = gerente; this.sprint = sprint;
    }
}
