public class Produto {
    private String nome;
    private Double preco;
    private String lote;

    public Produto(String nome, Double preco, String lote) {
        this.nome = nome;
        this.preco = preco;
        this.lote = lote;
    }
    public String getNome() {
        return nome;
    }
    public Double getPreco() {
        return preco;
    }
    public String getLote() {
        return lote;
    }
    
}
