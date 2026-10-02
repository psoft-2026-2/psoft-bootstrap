import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Empresa {
    private Pessoa productOwner;
    private final List<Produto> produtos;

    public Empresa(Pessoa pessoa, List<Produto> produtos) {
        Objects.requireNonNull(pessoa, "O Product Owner deve ser informado.");
        if (!(pessoa.getFuncao() instanceof ProductOwner)) {
            throw new IllegalArgumentException("A pessoa deve exercer a funcao de Product Owner.");
        }
        Objects.requireNonNull(produtos, "A lista de produtos deve ser informada.");
        this.produtos = new ArrayList<>();
        for (Produto produto : produtos) {
            Objects.requireNonNull(produto, "O produto deve ser informado.");
            for (Produto existente : this.produtos) {
                if (existente.getTime() == produto.getTime()) {
                    throw new IllegalArgumentException("Cada time deve ser responsavel por apenas um produto.");
                }
            }
            this.produtos.add(produto);
        }
        this.productOwner = pessoa;
    }

    public Pessoa getProductOwner() {
        return productOwner;
    }

    public List<Produto> getProdutos() {
        return Collections.unmodifiableList(new ArrayList<>(produtos));
    }

    public void updateProductOwner(Pessoa pessoa) {
        Objects.requireNonNull(pessoa, "O Product Owner deve ser informado.");
        if (pessoa == productOwner) {
            return;
        }
        if (!(pessoa.getFuncao() instanceof Gerente)) {
            throw new IllegalArgumentException("Somente um gerente pode ser promovido a Product Owner.");
        }
        boolean gerenteDaEmpresa = false;
        for (Produto produto : produtos) {
            if (produto.getTime().getGerente() == pessoa) {
                gerenteDaEmpresa = true;
                break;
            }
        }
        if (!gerenteDaEmpresa) {
            throw new IllegalArgumentException("O gerente deve pertencer a um time da empresa.");
        }
        pessoa.updateFuncao(new ProductOwner());
        productOwner = pessoa;
    }
}