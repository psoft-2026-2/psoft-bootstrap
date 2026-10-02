public class Produto {
    private String id;
    private String nome;

    public Produto(String id, String nome)
    {
        this.id = id;
        this.nome = nome;
    }

    public String getId()
    {
        return this.id;
    }

    public String getNome()
    {
        return this.nome;
    }
}
