public class Produto {

    private static final int QUANTIDADE_MINIMA_DESCONTO = 20;
    private static final double PERCENTUAL_DESCONTO_QUANTIDADE = 0.10;

    private final String id;
    private final String nome;
    private final double precoUnitario;

    public Produto(String id, String nome, double precoUnitario) {
        this.id = id;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public boolean temDescontoPorQuantidade(int quantidade) {
        return quantidade >= QUANTIDADE_MINIMA_DESCONTO;
    }

    public double calcularPrecoUnitarioComDesconto(int quantidade) {
        if (temDescontoPorQuantidade(quantidade)) {
            return precoUnitario * (1 - PERCENTUAL_DESCONTO_QUANTIDADE);
        }
        return precoUnitario;
    }

    @Override
    public String toString() {
        return String.format("%s (R$ %.2f)", nome, precoUnitario);
    }
}
