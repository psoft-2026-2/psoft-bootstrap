public class Product_Owner implements Papel {
    private String nome;
    private String idMembro;
    private List<String> prioridades;

    public Product_Owner(String nome, String idMembro) {
        this.nome = nome;
        this.idMembro = idMembro;
        this.prioridades = new ArrayList<>();
    }

    @Override
    public void escrever(String texto) {
        prioridades.add(texto);
    }

    @Override
    public String ler() {
        return String.join(", ", prioridades);
    }

    public String getNome() {
        return nome;
    }

    public String getIdMembro() {
        return idMembro;
    }

    public String gerenciarPrioridades() {
        return String.join(", ", prioridades);
    }

    public void setPrioridades(List<String> prioridades) {
        this.prioridades = prioridades;
    }

    public void adicionarPrioridade(String prioridade) {
        prioridades.add(prioridade);
    }

    public void removerPrioridade(String prioridade) {
        prioridades.remove(prioridade);
    }
}
