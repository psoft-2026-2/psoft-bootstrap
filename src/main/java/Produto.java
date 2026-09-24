public class Produto {
    private final String nome;
    private final double precoBase;

    public Produto(String nome, double precoBase) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do produto e obrigatorio.");
        }
        if (!Double.isFinite(precoBase) || precoBase < 0) {
            throw new IllegalArgumentException("Preco deve ser finito e nao negativo.");
        }
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public double getPrecoBase() {
        return precoBase;
    }
}
