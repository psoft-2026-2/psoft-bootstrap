import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Empresa {
    private final String nome;
    private final List<Produto> produtos = new ArrayList<>();
    private Funcionario productOwner;

    public Empresa(String nome, Funcionario productOwner) {
        if (Objects.requireNonNull(nome, "Nome obrigatório.").isBlank()) {
            throw new IllegalArgumentException("Nome não pode estar vazio.");
        }
        this.nome = nome.trim();
        definirProductOwner(productOwner);
    }

    public String getNome() {
        return nome;
    }

    public Funcionario getProductOwner() {
        return productOwner;
    }

    public List<Produto> getProdutos() {
        return List.copyOf(produtos);
    }

    public void definirProductOwner(Funcionario funcionario) {
        Objects.requireNonNull(funcionario, "Product Owner obrigatório.");
        if (!funcionario.possuiPapel(PapelProductOwner.class)) {
            throw new IllegalArgumentException("O funcionário deve exercer o papel de Product Owner.");
        }
        productOwner = funcionario;
    }

    public void adicionarProduto(Produto produto) {
        Objects.requireNonNull(produto, "Produto obrigatório.");
        if (produto.getTime() == null) {
            throw new IllegalStateException("Crie o time responsável antes de cadastrar o produto.");
        }
        if (produto.getEmpresa() != null && produto.getEmpresa() != this) {
            throw new IllegalArgumentException("O produto já pertence a outra empresa.");
        }
        if (!produtos.contains(produto)) {
            produtos.add(produto);
            produto.vincularEmpresa(this);
        }
    }
}
