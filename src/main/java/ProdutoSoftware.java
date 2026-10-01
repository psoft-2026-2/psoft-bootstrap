public class ProdutoSoftware {
    private String id;
    private String nome;
    private String versao;

    public ProdutoSoftware(String id, String nome, String versao) {
        this.id = id;
        this.nome = nome;
        this.versao = versao;
    }

    public void atualizarVersao(String novaVersao) {
        this.versao = novaVersao;
        System.out.println("Produto " + nome + " atualizado para a versão " + novaVersao);
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getVersao() { return versao; }
}