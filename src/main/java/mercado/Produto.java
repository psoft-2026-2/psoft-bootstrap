package mercado;

public class Produto {
    private String id;
    private String descricao;
    private double precoBase;

    public Produto(String id, String descricao, double precoBase) {
        this.id = id;
        this.descricao = descricao;
        this.precoBase = precoBase;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }
}
