package sprint;

public class LiderTime implements Papel {
    private Papel papelDecorado;

    public LiderTime(Papel papelDecorado) {
        this.papelDecorado = papelDecorado;
    }

    public Papel getPapelDecorado() {
        return papelDecorado;
    }

    @Override
    public String getDescricao() {
        return papelDecorado.getDescricao() + " + Lider de Time";
    }

    @Override
    public void executarFuncao() {
        papelDecorado.executarFuncao();
        System.out.println("  -> [Lider] Coordenando as cerimonias da Sprint.");
    }
}
