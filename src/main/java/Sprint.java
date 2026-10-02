public class Sprint {
    private int ciclo;
    private Funcionario lider;

    public Sprint(int ciclo) {
        if (ciclo <= 0) {
            throw new IllegalArgumentException("ciclo invalido");
        }
        this.ciclo = ciclo;
    }

    public int getCiclo() {
        return ciclo;
    }

    public Funcionario getLider() {
        return lider;
    }

    public void defineLider(Funcionario lider) {
        if (lider == null) {
            throw new IllegalArgumentException("lider invalido");
        }
        this.lider = lider;
    }

    public void atualizaCiclo() {
        this.ciclo++;
    }
}
