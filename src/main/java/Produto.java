public class Produto {
    private String nome;
    private String descricao;
    private int codigo;
    private String lote;
    private double preco;

    public Produto(String nome, String descricao, int codigo, String lote, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigo = codigo;
        this.lote = lote;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public String getLote() {
        return lote;
    }

    @Override
    public String toString() {
        return "Produto{nome='" + nome + "', descricao='" + descricao +
                "', codigo=" + codigo + ", lote='" + lote + "', preco=" + preco + "}";
    }
}
