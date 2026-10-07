package sprint;

import java.time.LocalDate;

public class Sprint {
    private int numero;
    private LocalDate inicio;
    private LocalDate fim;
    private Funcionario lider;

    public Sprint(int numero, Funcionario lider) {
        this.numero = numero;
        this.lider = lider;
        this.inicio = LocalDate.now();
    }

    public void iniciar() {
        System.out.println("\n>>> Sprint " + numero + " iniciada sob lideranca de: " + lider.getNome());
    }

    public void finalizar() {
        this.fim = LocalDate.now();
        System.out.println(">>> Sprint " + numero + " finalizada.");
    }
}
