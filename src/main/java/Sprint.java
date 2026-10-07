import java.time.LocalDateTime;

public class Sprint {

    private static int proximoNumero = 1;

    private Funcionario lider;
    private LocalDateTime dataInicio;
    private int numero;

    public Sprint(Funcionario lider) {

        if (lider == null) {
            throw new IllegalArgumentException(
                    "A Sprint deve possuir um líder."
            );
        }

        if (!lider.temCargo(new Desenvolvedor())) {
            throw new IllegalArgumentException(
                    "O líder da Sprint deve ser um desenvolvedor."
            );
        }

        lider.adicionarCargo(new Lider());

        this.lider = lider;
        this.dataInicio = LocalDateTime.now();
        this.numero = proximoNumero++;
    }

    public Funcionario getLider() {
        return lider;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public int getNumero() {
        return numero;
    }
}