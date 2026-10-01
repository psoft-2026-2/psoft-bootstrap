public class ProdutoSoftware {

    private static int proximoId = 1;

    private int id;
    private String nome;
    private String descricao;

    public ProdutoSoftware(String nome, String descricao) {

        this.id = proximoId++;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}