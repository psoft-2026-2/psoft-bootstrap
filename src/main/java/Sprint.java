import java.time.Duration;
import java.util.Date;

public final class Sprint {
    private String objetivo;
    private String lider;
    private Date inicio;
    private Date fim;

    public Sprint(String objetivo, String lider, Date inicio, Date fim) {
        this.objetivo = objetivo;
        this.lider = lider;
        setPeriodo(inicio, fim);
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        setPeriodo(inicio, fim);
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        setPeriodo(inicio, fim);
    }

    public void setPeriodo(Date inicio, Date fim) {
        if (!fim.after(inicio)) {
            throw new IllegalArgumentException("Fim deve ser posterior ao início");
        }
        this.inicio = inicio;
        this.fim = fim;
    }

    public boolean estaEmAndamento(Date data) {
        return !data.before(inicio) && data.before(fim);
    }

    public long getDuracaoEmDias() {
        return Duration.between(inicio.toInstant(), fim.toInstant()).toDays();
    }
}
