public class ItemDeVenda {
    public static final int QUANTIDADE_MINIMA_PARA_DESCONTO = 20;
    public static final double DESCONTO_QUANTIDADE = 0.10;

    private final String id;
    private final int quantidade;
    private final Produto produto;

    public ItemDeVenda(String id, int quantidade, Produto produto) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("id invalido");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("quantidade invalido");
        }
        if (produto == null) {
            throw new IllegalArgumentException("produto invalido");
        }

        this.id = id.trim();
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public String getId() {
        return id;
    }

    public int getQtd() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double CalculaPrecoBruto() {
        return produto.getPreco() * quantidade;
    }

    public double CalculaPreco() {
        double preco = CalculaPrecoBruto();

        if (quantidade >= QUANTIDADE_MINIMA_PARA_DESCONTO) {
            preco -= preco * DESCONTO_QUANTIDADE;
        }

        return preco;
    }
}
