package atv2;

public class Sprint {
    private int numero;
    private Funcionario lider;
    private Papel papelLider;

    public Sprint(int numero, Funcionario lider, Papel papelLider) {
        this.numero = numero;
        this.lider = lider;
        this.papelLider = papelLider;
    }

    public void iniciar() { lider.atribuirPapelTemporario(papelLider); }
    public void encerrar() { lider.encerrarPapelTemporario(papelLider); }
    public Funcionario getLider() { return lider; }
    public int getNumero() { return numero; }
}