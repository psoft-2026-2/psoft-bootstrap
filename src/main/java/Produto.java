public class Produto {
    private final String id;
    private final String nome;
    private final double preco;

    public Produto(String id, String nome, double preco) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("objeto invalido");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("objeto invalido");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("objeto invalido");
        }

        this.id = id.trim();
        this.nome = nome.trim();
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
