import java.util.Objects;
import java.util.UUID;


public class Produto {

    private final String id;
    private final String nome;
    private final double precoUnitario;

    public Produto(String nome, double precoUnitario) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser vazio");
        }
        if (precoUnitario < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.id = UUID.randomUUID().toString();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}