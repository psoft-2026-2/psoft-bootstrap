public class Sprint {
    private int numero;
    private Funcionario lider;

    public Sprint(int numero, Funcionario lider) {
        if (lider.getPapel() != Papel.DESENVOLVEDOR) {
            throw new IllegalArgumentException("O lider deve ser um desenvolvedor.");
        }
        this.numero = numero;
        this.lider = lider;
        this.lider.setEhLider(true);
    }

    public int getNumero() {
        return this.numero;
    }

    public Funcionario getLider() {
        return this.lider;
    }
}