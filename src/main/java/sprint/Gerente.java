package sprint;

public class Gerente implements Papel {
    private String setor;

    public Gerente(String setor) {
        this.setor = setor;
    }

    @Override
    public String getDescricao() {
        return "Gerente (setor: " + setor + ")";
    }

    @Override
    public void executarFuncao() {
        System.out.println("  -> Gerenciando a equipe do setor: " + setor);
    }
}
