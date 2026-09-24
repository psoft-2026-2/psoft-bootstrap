import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Mercado {

    private final String nome;
    private final List<Produto> produtos;
    private final List<Venda> vendas;

    public Mercado(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do mercado não pode ser vazio");
        }
        this.nome = nome;
        this.produtos = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public void addVenda(Venda venda) {
        vendas.add(venda);
    }

    public List<Produto> getProdutos() {
        return Collections.unmodifiableList(produtos);
    }

    public List<Venda> getVendas() {
        return Collections.unmodifiableList(vendas);
    }
}