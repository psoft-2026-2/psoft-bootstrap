import java.util.HashMap;
import java.util.Map;

public class ItemVenda {
    private Map<Produto, Integer> produtosVenda;

    public ItemVenda() {
        this.produtosVenda = new HashMap<>();
    }

    public float subtotal() {
        float total = 0;
        for (Map.Entry<Produto, Integer> e : produtosVenda.entrySet()) {
            total += e.getKey().getPreco() * e.getValue();
        }
        return total;
    }

    private float desconto() {
        float d = 0;
        for (Map.Entry<Produto, Integer> e : produtosVenda.entrySet()) {
            int qtd = e.getValue();
            if (qtd >= 20) {
                d += e.getKey().getPreco() * qtd * 0.10f;
            }
        }
        return d;
    }

    float descontoInterno() {
        return desconto();
    }

    Map<Produto, Integer> getProdutosVenda() {
        return produtosVenda;
    }

    void adicionarProduto(Produto produto, int quantidade) {
        if (produto == null) {
            return;
        }
        Integer atual = produtosVenda.get(produto);
        if (atual == null) {
            produtosVenda.put(produto, quantidade);
        } else {
            produtosVenda.put(produto, atual + quantidade);
        }
    }
}
