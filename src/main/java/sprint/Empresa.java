package sprint;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private List<Produto> produtos;
    private Funcionario productOwner;

    public Empresa(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void definirProductOwner(Funcionario po) {
        this.productOwner = po;
    }

    public String getNome() { return nome; }
    public Funcionario getProductOwner() { return productOwner; }
}
