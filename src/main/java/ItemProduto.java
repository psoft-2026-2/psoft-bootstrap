import java.util.ArrayList;
import java.util.List;

public class ItemProduto {

    private List<Produto> produtos;

    public ItemProduto() {
        this.produtos = new ArrayList<>();
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.calcularSubtotal();
        }
        return total;
    }
}