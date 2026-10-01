import java.util.List;

public class Empresa {

    private String nome;
    private List<Produto> produtos;
    private Funcionario owner;

    public Empresa(String nome, List<Produto> produtos, Funcionario owner) {
        this.nome = nome;
        this.produtos = produtos;
        this.owner = owner;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novo) {
        this.nome = novo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> nova) {
        this.produtos = nova;
    }

    public void addProduto(Produto p) {
        produtos.add(p);
    }

    public void removeProduto(Produto p) {
        produtos.remove(p);
    }

    public Funcionario getOwner() {
        return owner;
    }

    public void setOwner(Funcionario novo) {
        this.owner = novo;
    }
}
