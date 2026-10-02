package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sprint {
    private final String id;
    private final String nome;
    private final LocalDate dataInicio; //adicionei as q eu esqueci no miniteste
    private final LocalDate dataFim;
    private Funcionario liderSprint;
    private final List<String> backlog;
    private StatusSprint status;

    public Sprint(String id, String nome, LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.backlog = new ArrayList<>();
        this.status = StatusSprint.PLANEJADA;
        this.liderSprint = null;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public Funcionario getLiderSprint() { //esse eh o lugar certo
        return liderSprint;
    }

    public void setLiderSprint(Funcionario lider) {
        if (this.liderSprint != null && this.liderSprint.ehLider()) {
            this.liderSprint.renunciarLideranca();
        }
        this.liderSprint = lider;
    }

    public List<String> getBacklog() {
        return new ArrayList<>(backlog);
    }

    public void adicionarAoBacklog(String item) {
        backlog.add(item);
    }

    public void removerDoBacklog(String item) {
        backlog.remove(item);
    }

    public StatusSprint getStatus() {
        return status;
    }

    public void setStatus(StatusSprint status) {
        this.status = status;
    }

    public void iniciar() {
        this.status = StatusSprint.EM_ANDAMENTO;
    }

    public void finalizar() {
        this.status = StatusSprint.FINALIZADA;
        if (liderSprint != null && liderSprint.ehLider()) {
            liderSprint.renunciarLideranca();
            liderSprint = null;
        }
    }

    public void cancelar() {
        this.status = StatusSprint.CANCELADA;
        if (liderSprint != null && liderSprint.ehLider()) {
            liderSprint.renunciarLideranca();
            liderSprint = null;
        }
    }

    public void conduzirDaily() {
        if (liderSprint != null && liderSprint.ehLider()) {
            System.out.println(liderSprint.getNome() + " conduzindo daily standup");
        }
    }

    public void facilitarRetrospectiva() {
        if (liderSprint != null && liderSprint.ehLider()) {
            System.out.println(liderSprint.getNome() + " facilitando retrospectiva");
        }
    }

    public void removerImpedimentos() {
        if (liderSprint != null && liderSprint.ehLider()) {
            System.out.println(liderSprint.getNome() + " removendo impedimentos da equipe");
        }
    }
}