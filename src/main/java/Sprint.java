public class Sprint {
    private int numero;
    private Funcionario lider;
    private boolean encerrada;

    public Sprint(int num, Funcionario lider) {
        this.numero = num;
        this.lider = lider;
        this.encerrada = false;

        lider.addFuncao(new Lider());
    }

    public boolean encerrar() {
        if (encerrada) {
            return false;
        }

        lider.removeFuncao(new Lider());
        encerrada = true;
        return true;
    }

    public int getNumero() {
        return numero;
    }

    public Funcionario getLider() {
        return lider;
    }

    public boolean isEncerrada() {
        return encerrada;
    }
}
