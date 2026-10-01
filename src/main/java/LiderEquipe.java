public class LiderEquipe implements Papel {
    private String dataInicio;

    public LiderEquipe(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String getNome() {
        return "Líder de Equipe";
    }

    @Override
    public void executar() {
        System.out.println("-> Orientando a equipe, conduzindo rituais da Sprint e removendo impedimentos.");
    }
}