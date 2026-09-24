import java.util.HashMap;
import java.util.Map;

public class Produto {
    private String nome;
    private float preco;
    private int id;
    private static final Map<Integer, Produto> produtos = new HashMap<>();
    
    public Produto(String nome, float preco, int id) {
        this.nome = nome;
        this.preco = preco;
        this.id = id;
        produtos.put(id, this);
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public int getId() {
        return id;
    }

    public static Produto getProduto(int id) {
        return produtos.get(id);
    }
}