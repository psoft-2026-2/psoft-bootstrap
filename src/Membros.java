public class Membros {
    private String nome;
    private String idMembro;
    private List<Papel> papeis;

    public Membros(String nome, String idMembro) {
        this.nome = nome;
        this.idMembro = idMembro;
        this.papeis = new ArrayList<>();
    }

    public void adicionarPapel(Papel papel) {
        this.papeis.add(papel);
    }

    public void removerPapel(Papel papel) {
        this.papeis.remove(papel);
    }

    public boolean possuiPapel(Papel papel) {
        return this.papeis.contains(papel);
    }

    public String getNome() {
        return nome;
    }

    public String getIdMembro() {
        return idMembro;
    }

    
}