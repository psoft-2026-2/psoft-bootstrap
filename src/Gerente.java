public class Gerente implements Papel {
    private String nome;
    private String idMembro;
    private List<String> tarefas;

    public Gerente(String nome, String idMembro) {
        this.nome = nome;
        this.idMembro = idMembro;
        this.tarefas = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }

    public String getIdMembro() {
        return idMembro;
    }

    public String getTarefas() {
        return String.join(", ", tarefas);
    }

}