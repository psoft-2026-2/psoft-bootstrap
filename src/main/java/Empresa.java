import java.util.*;

public class Empresa {
    private Pessoa productOwner;
    private List<Pessoa> pessoas;
    private List<Time> times;
    private List<Produto> produtos;

    public Empresa() {
    }

    public Empresa(Pessoa productOwner) {
        this.productOwner = productOwner;
        this.pessoas = new ArrayList<>();
        this.times = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public boolean removePessoa(Pessoa pessoa){
        return pessoas.remove(pessoa);
    }

    public void cadastrarTime(Time time) {
        times.add(time);
    }

    public boolean removerTime(Time time) {
        return times.remove(time);
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public boolean removeProduto(Produto Produto){
        return produtos.remove(Produto);
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public List<Time> getTimes() {
        return times;
    }

    public Pessoa getProductOwner() {
        return productOwner;
    }

    public void alterarProductOwner(Pessoa productOwner) {
        this.productOwner = productOwner;
    }
    
    public boolean promoverCargo(Pessoa pessoa, Cargo novoCargo) {
        if (!pessoas.contains(pessoa) && pessoa != productOwner) {
            return false;
        }

        pessoa.setCargo(novoCargo);

        if (novoCargo instanceof ProductOwner) {
            this.productOwner = pessoa;
        }

        return true;
    }
}