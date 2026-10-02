public class Produto {
    private static int proximoId = 1;

    private String nome;
    private int id;

    public Produto(String nome) {
        this.nome = nome;
        this.id = proximoId++;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}
