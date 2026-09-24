public class Produto {
    private String descricao;
    private double precoBase;

    public Produto(String descricao, double precoBase) {
        this.descricao = descricao;
        this.precoBase = precoBase;
    }

    public double getPrecoBase() {
        return precoBase;
    }
}