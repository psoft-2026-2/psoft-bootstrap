package sprint;

public class Desenvolvedor implements Papel {
    private String especialidade;

    public Desenvolvedor(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String getDescricao() {
        return "Desenvolvedor (" + especialidade + ")";
    }

    @Override
    public void executarFuncao() {
        System.out.println("  -> Codificando na especialidade: " + especialidade);
    }
}
