import java.util.List;

public class Time {
    private Produto produto;
    private List<Funcionario> membros;
    private Funcionario gerente;

    public Time(Produto produto, List<Funcionario> membros, Funcionario gerente) {
        this.produto = produto;
        this.membros = membros;
        this.gerente = gerente;
    }
}