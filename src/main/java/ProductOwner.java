import java.util.ArrayList;
import java.util.List;

public class ProductOwner implements Cargo {
    private List<Software> produtos;

    public ProductOwner() {
        this(new ArrayList<>());
    }

    public ProductOwner(List<Software> produtos) {
        this.produtos = produtos;
    }

    public List<Software> getProdutos() {
        return produtos;
    }

    public void alocaProduto(Software produto) {
        produtos.add(produto);
    }

    public void removeProduto(Software produto) {
        produtos.remove(produto);
    }

    @Override
    public String getCargo() {
        return "Product Owner";
    }

    @Override
    public void executaFuncao() {
        if (produtos.isEmpty()) {
            System.out.println("Product Owner sem produtos associados");
            return;
        }
        for (Software produto : produtos) {
            System.out.println("Product Owner priorizando o software " + produto.getNome()
                    + " (id " + produto.getId() + ")");
        }
    }

    @Override
    public Cargo promocao() {
        return this;
    }
}
