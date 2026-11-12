import java.util.ArrayList;
import java.util.List;

public class Central {

    private static Central instance;
    private final List<Produto> produtos;

    private Central() {
        this.produtos = new ArrayList<>();
    }

    public static Central getInstance() {
        if (instance == null) {
            instance = new Central();
        }
        return instance;
    }

    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        produtos.add(produto);
    }

    public boolean removerProduto(String idProduto) {
        if (idProduto == null || idProduto.isBlank()) {
            throw new IllegalArgumentException("O id do produto não pode ser nulo ou vazio.");
        }
        return produtos.removeIf(produto -> idProduto.equals(produto.getId()));
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void alterarEstrategiaEntrega(String idProduto, EstrategiaEntrega novaEstrategia) {
        if (novaEstrategia == null) {
            throw new IllegalArgumentException("A nova estratégia de entrega não pode ser nula.");
        }
        Produto produto = buscarProdutoPorId(idProduto);
        produto.setEstrategiaEntrega(novaEstrategia);
    }

    public void despacharProduto(String idProduto) {
        Produto produto = buscarProdutoPorId(idProduto);
        produto.despachar();
    }

    private Produto buscarProdutoPorId(String idProduto) {
        if (idProduto == null || idProduto.isBlank()) {
            throw new IllegalArgumentException("O id do produto não pode ser nulo ou vazio.");
        }
        for (Produto produto : produtos) {
            if (idProduto.equals(produto.getId())) {
                return produto;
            }
        }
        throw new IllegalArgumentException("Produto não encontrado");
    }
}
