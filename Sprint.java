public class Sprint {
    private int numero;
    private Funcionario lider;
    private Lider funcaoLider = new Lider();

    public Sprint(int numero, Funcionario lider) {
        this.numero = numero;
        this.lider = lider;
    }

    public void iniciar() {
        lider.adicionarFuncao(funcaoLider);
    }

    public void terminar() {
        lider.removerFuncao(funcaoLider);
    }

    public int getNumero() {
        return numero;
    }

    public Funcionario getLider() {
        return lider;
    }
}