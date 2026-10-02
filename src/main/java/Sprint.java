package atv2;

public class Sprint {
    private String id;
    private Time time;
    private Funcionario lider;

    public Sprint(String id, Time time, Funcionario lider) {
        this.id = id;
        this.time = time;
        this.lider = null;
        setLider(lider);
    }
    
    public void setLider(Funcionario novoLider) {
        if (!time.temDesenvolvedor(novoLider)) {
            throw new IllegalArgumentException("O líder precisa ser desenvolvedor do time.");
        }
        if (this.lider != null) {
            this.lider.deixarLideranca();
        }
        novoLider.assumirLideranca();
        this.lider = novoLider;
    }

    public void encerrar() {
        lider.deixarLideranca();
    }

    public String getId() {
        return id;
    }

    public Time getTime() {
        return time;
    }

    public Funcionario getLider() {
        return lider;
    }

    @Override
    public String toString() {
        return "Sprint " + id + " - time: " + time.getId() + ", líder: " + lider.getNome();
    }
}
