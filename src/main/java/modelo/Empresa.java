package modelo;

import funcao.ProductOwner;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private final String nome;
    private Funcionario productOwnerGeral;
    private final List<Produto> produtos;
    private final List<Time> times;

    public Empresa(String nome, Funcionario productOwnerGeral) {
        this.nome = nome;
        this.productOwnerGeral = productOwnerGeral;
        this.produtos = new ArrayList<>();
        this.times = new ArrayList<>();

        if (productOwnerGeral != null) {
            productOwnerGeral.setFuncaoAtual(new ProductOwner());
        }
    }

    public String getNome() {
        return nome;
    }

    public Funcionario getProductOwnerGeral() {
        return productOwnerGeral;
    }

    public void setProductOwnerGeral(Funcionario productOwnerGeral) {
        this.productOwnerGeral = productOwnerGeral;
        if (productOwnerGeral != null) {
            productOwnerGeral.setFuncaoAtual(new ProductOwner());
        }
    }

    public List<Produto> getProdutos() {
        return new ArrayList<>(produtos);
    }

    public void cadastrarProduto(Produto produto) {
        if (!produtos.contains(produto)) {
            produtos.add(produto);
        }
    }

    public List<Time> getTimes() {
        return new ArrayList<>(times);
    }

    public void cadastrarTime(Time time) {
        if (!times.contains(time)) {
            times.add(time);
            if (time.getProduto() != null && !produtos.contains(time.getProduto())) {
                cadastrarProduto(time.getProduto());
            }
        }
    }

    public void promoverGerenteAProductOwner(Funcionario gerente) {
        if (productOwnerGeral == null && gerente != null && gerente.ehGerente()) {
            gerente.promoverAProductOwner();
            this.productOwnerGeral = gerente;
        }
    }

    public List<Funcionario> getTodosFuncionarios() {
        List<Funcionario> todos = new ArrayList<>();
        if (productOwnerGeral != null) {
            todos.add(productOwnerGeral);
        }
        for (Time time : times) {
            todos.addAll(time.getTodosMembros());
        }
        return todos;
    }
}