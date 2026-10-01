package funcao;

public class Dev implements Funcao {
    @Override
    public String getNome() {
        return "Dev";
    }

    @Override
    public void executar() {
        System.out.println("Desenvolvendo software");
    }
}