import java.util.*;

public class Empresa {
    private List<Produto> produtos;

    public Empresa() {
        this.produtos = new ArrayList<>();
    }

    public void addProdutos(Produto produto) {
        produtos.add(produto);
    }

    public String listaProdutos() {
        StringBuilder sb = new StringBuilder();
        for (Produto p : produtos) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}
