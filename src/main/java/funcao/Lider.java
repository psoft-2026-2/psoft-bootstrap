package funcao;

public class Lider implements Funcao {
    private final Funcao funcaoOriginal;

    public Lider(Funcao funcaoOriginal) {
        this.funcaoOriginal = funcaoOriginal;
    }

    @Override
    public String getNome() {
        return "Lider (" + funcaoOriginal.getNome() + ")";
    }

    @Override
    public void executar() {
        System.out.println("Liderando sprint: conduzindo daily, facilitando retrospectiva, removendo impedimentos");
        funcaoOriginal.executar();
    }

    public Funcao getFuncaoOriginal() {
        return funcaoOriginal;
    }
}