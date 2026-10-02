public class Time {

    private String id;
    private Funcionario lider;
    private Sprint sprintAtual;

    public Time(String id, Funcionario lider) {
        this.id = id;
        setLider(lider);
    }

    public Sprint novoSprint(String idSprint, ProdutoSoftware produto) {
        if (sprintAtual != null && !sprintAtual.encerrada())
            throw new IllegalStateException("Time " + id + " ainda está na sprint " + sprintAtual.getId());
        sprintAtual = new Sprint(idSprint, produto);
        return sprintAtual;
    }

    public String getId() {return id;}

    public Funcionario getLider() {return lider;}

    public void setLider(Funcionario lider) {
        if (!lider.temPapel(Lider.class))
            throw new IllegalArgumentException(lider.getNome() + " não possui o papel Líder");
        this.lider = lider;
    }

    public Sprint getSprint() {return sprintAtual;}

    @Override
    public String toString() {
        return "Time [id=" + id + ", lider=" + lider.getNome() + ", sprintAtual="
                + (sprintAtual == null ? "nenhuma" : sprintAtual.getId()) + "]";
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Time other = (Time) obj;
        return id == null ? other.id == null : id.equals(other.id);
    }
}
