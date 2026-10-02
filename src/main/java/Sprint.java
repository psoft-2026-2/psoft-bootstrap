public class Sprint {

    private int id;
    private final Time time;
    private Funcionario lider;

    public Sprint(int identificador, Time time, Funcionario lider) {
        this.id = identificador;
        this.time = time;
        this.lider = lider;
    }

    public int getId() {
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
        return "ID: " + id + " | PRODUTO: " + time.getProduto() + " | LIDER: " + lider.getNome();
    }
}