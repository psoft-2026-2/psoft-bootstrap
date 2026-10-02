import java.util.*;

public class Empresa {
    private Pessoa productOwner;
    private List<Pessoa> pessoas;
    private List<Time> times;
    private List<Produto> produtos;

    public Empresa() {
        this.pessoas = new ArrayList<>();
        this.times = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }

    public Empresa(String nomeProductOwner) {
        this.productOwner = new Pessoa(nomeProductOwner, "productOwner");
        this.pessoas = new ArrayList<>();
        this.times = new ArrayList<>();
        this.produtos = new ArrayList<>();

        this.pessoas.add(this.productOwner);
    }

    public void cadastrarPessoa(String nome, String cargo) {
        pessoas.add(new Pessoa(nome, cargo));
    }

    public boolean removerPessoa(String nome) {
        for (Pessoa p : pessoas) {
            if (p.getNome().equals(nome)) {
                return pessoas.remove(p);
            }
        }
        return false;
    }

    public void cadastrarProduto(String nome, int id) {
        produtos.add(new Produto(nome, id));
    }

    public boolean removerProduto(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return produtos.remove(p);
            }
        }
        return false;
    }

    public void cadastrarTime(String nomeGerente) {
        times.add(new Time(nomeGerente));
    }

    public boolean removerTime(int indice) {
        if (indice >= 0 && indice < times.size()) {
            times.remove(indice);
            return true;
        }
        return false;
    }

    public Pessoa buscarPessoa(String nome) {
        for (Pessoa p : pessoas) {
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }

    public boolean promoverPessoa(String nome, String novoCargo) {
        Pessoa pessoa = buscarPessoa(nome);
        if (pessoa == null) {
            return false;
        }
        pessoa.setCargo(novoCargo);
        if (novoCargo.equals("productOwner")){
            this.productOwner = pessoa;
        }

        return true;
    }

    public void alterarProductOwner(String nome) {
        promoverPessoa(nome, "productOwner");
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public List<Time> getTimes() {
        return times;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Pessoa getProductOwner() {
        return productOwner;
    }
}
