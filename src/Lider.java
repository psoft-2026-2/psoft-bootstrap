public class Lider implements Papel {
    private String nome;
    private String idMembro;
    private List<Sprint> sprintAtual;


    public Lider(Sprint sprintAtual) {
        this.sprintAtual = Arrays.asList(sprintAtual);
    }

    public void AddSprint(Sprint sprint) {
        this.sprintAtual.add(sprint);
    }

    public void atualizarSprint(Sprint sprint) {
        this.sprintAtual.clear();
        this.sprintAtual.add(sprint);
    }

}