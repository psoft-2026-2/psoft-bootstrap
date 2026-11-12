package mercado;

public class Produto {

    private String codigo;
    private String descricao;
    private double precoInicial;

    public Produto(String codigo, String descricao, double precoInicial) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoInicial = precoInicial;
    }

    public double getPrecoInicial() {
        return precoInicial;
    }
}
