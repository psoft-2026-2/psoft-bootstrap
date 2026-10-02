public class Produto {
    private String nome;
    private String descricao;

    public Produto(String nome, String descricao) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("nome invalido");
        }
        this.nome = nome.trim();
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
