import java.util.ArrayList;
import java.util.List;

public class ItensVenda {
    private List<ProdutoModel> produtos;

    public ItensVenda() {
        this.produtos = new ArrayList<>();
    }

    public void addProduto(ProdutoModel produto) {
        this.produtos.add(produto);
    }

    public void removeProduto(String id) {
        this.produtos.removeIf(produto -> produto.getId().equals(id));
    }

    public float getSubTotal() {
        float total = 0;
        for (ProdutoModel p : produtos) {
            total += p.getValor();
        }
        return total;
    }

    public int getQuantidade() {
        return produtos.size();
    }
}