public class Sprint {
    private int numero;
    private Lider lider;

    public Sprint(int numero, Lider lider) {
        this.numero = numero;
        this.lider = lider;
    }

    public void definirLider(Lider lider) {
        this.lider = lider;
    }

    public void executar() {
        if (lider != null) {
            lider.liderarSprint(this);
        }
    }
}