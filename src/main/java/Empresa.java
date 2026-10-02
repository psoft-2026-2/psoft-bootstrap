package atv2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Empresa {
    private Funcionario productOwner;
    private Map<String, Funcionario> funcionarios;
    private Map<String, Produto> produtos;
    private Map<String, Time> times;
    private Map<String, Sprint> sprints;
    private Map<String, Sprint> ultimaSprint;

    public Empresa() {
        this.productOwner = null;
        this.funcionarios = new HashMap<>();
        this.produtos = new HashMap<>();
        this.times = new HashMap<>();
        this.sprints = new HashMap<>();
        this.ultimaSprint = new HashMap<>();
    }

    public Funcionario criarFuncionario(String id, String nome) {
        Funcionario f = new Funcionario(id, nome);
        funcionarios.put(id, f);
        return f;
    }

    public Funcionario buscarFuncionario(String id) {
        return funcionarios.get(id);
    }

    public Collection<Funcionario> listarFuncionarios() {
        return funcionarios.values();
    }

    public void atualizarFuncionario(String id, String novoNome) {
        funcionarios.get(id).setNome(novoNome);
    }

    public void removerFuncionario(String id) {
        funcionarios.remove(id);
    }

    public void promoverAGerente(String id) {
        funcionarios.get(id).promoverAGerente();
    }

    public void promoverAProductOwner(String id) {
        Funcionario f = funcionarios.get(id);
        f.promoverAProductOwner();
        productOwner = f;
    }

    public Funcionario getProductOwner() {
        return productOwner;
    }

    public Produto criarProduto(String id, String nome) {
        Produto p = new Produto(id, nome);
        produtos.put(id, p);
        return p;
    }

    public Produto buscarProduto(String id) {
        return produtos.get(id);
    }

    public Collection<Produto> listarProdutos() {
        return produtos.values();
    }

    public void atualizarProduto(String id, String novoNome) {
        produtos.get(id).setNome(novoNome);
    }

    public void removerProduto(String id) {
        produtos.remove(id);
    }

    public Time criarTime(String id, String idProduto, String idGerente) {
        Time t = new Time(id, produtos.get(idProduto), funcionarios.get(idGerente));
        times.put(id, t);
        return t;
    }

    public Time buscarTime(String id) {
        return times.get(id);
    }

    public Collection<Time> listarTimes() {
        return times.values();
    }

    public void atualizarGerenteDoTime(String idTime, String idGerente) {
        times.get(idTime).setGerente(funcionarios.get(idGerente));
    }

    public void removerTime(String id) {
        times.remove(id);
    }

    public void adicionarDesenvolvedorAoTime(String idTime, String idDev) {
        times.get(idTime).adicionarDesenvolvedor(funcionarios.get(idDev));
    }

    public void removerDesenvolvedorDoTime(String idTime, String idDev) {
        times.get(idTime).removerDesenvolvedor(funcionarios.get(idDev));
    }

    public Sprint criarSprint(String id, String idTime, String idLider) {
        Funcionario lider = funcionarios.get(idLider);
        Sprint anterior = ultimaSprint.get(idTime);
        if (anterior != null && anterior.getLider() == lider) {
            throw new IllegalArgumentException("O líder deve ser diferente do da sprint anterior.");
        }
        if (anterior != null) {
            anterior.encerrar();
        }
        Sprint s = new Sprint(id, times.get(idTime), lider);
        sprints.put(id, s);
        ultimaSprint.put(idTime, s);
        return s;
    }

    public Sprint buscarSprint(String id) {
        return sprints.get(id);
    }

    public Collection<Sprint> listarSprints() {
        return sprints.values();
    }

    public void atualizarLiderDaSprint(String idSprint, String idLider) {
        sprints.get(idSprint).setLider(funcionarios.get(idLider));
    }

    public void removerSprint(String id) {
        sprints.remove(id);
    }
}
