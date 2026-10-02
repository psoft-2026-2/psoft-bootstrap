
import java.time.LocalDate;

public class Sprint {

    private int numero;
    private LocalDate inicio;
    private LocalDate fim;
    private Colaborador lider;

    public Sprint(int numero, LocalDate inicio, LocalDate fim) {
        this.numero = numero;
        this.inicio = inicio;
        this.fim = fim;
    }

    //só um colaborador Líder pode liderar a equipe
    public void definirLider(Colaborador colaborador) {
        if (!colaborador.temPapel(Lider.class)) {
            throw new IllegalArgumentException(
                "O colaborador '" + colaborador.getNome() + "' nao exerce o papel de Lider.");
        }
        this.lider = colaborador;
    }

    public Colaborador getLider() {
        return lider;
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
}
