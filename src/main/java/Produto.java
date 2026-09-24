public class Produto {
    private final int idProduto;
    private String descricao;
    private float valor;

    public Produto(int idProduto, String descricao, float valor) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
