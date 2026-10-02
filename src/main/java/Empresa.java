import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Empresa {

    private String nome;
    private List<Time> times = new ArrayList<>();
    private Funcionario productOwner;

    public Empresa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Funcionario getProductOwner() {
        return productOwner;
    }

    public List<Time> getTimes() {
        return Collections.unmodifiableList(times);
    }

    public List<Produto> getProdutos() {
        List<Produto> produtos = new ArrayList<>();
        for (Time t : times) {
            produtos.add(t.getProduto());
        }
        return Collections.unmodifiableList(produtos);
    }

    public void adicionarTime(Time time) {
        times.add(time);
    }

    public void promoverAGerente(Funcionario desenvolvedor, Time time) {
        if (!desenvolvedor.possuiPapel("Desenvolvedor")) {
            throw new IllegalArgumentException(desenvolvedor.getNome() + " não é desenvolvedor.");
        }
        if (time.getGerente() != null) {
            throw new IllegalStateException("O time já possui gerente.");
        }
        time.removerDesenvolvedor(desenvolvedor);
        desenvolvedor.substituirPapeis(new Gerente());
        time.definirGerente(desenvolvedor);
    }

    public void promoverAProductOwner(Funcionario gerente, Time time) {
        if (!gerente.possuiPapel("Gerente") || !gerente.equals(time.getGerente())) {
            throw new IllegalArgumentException(gerente.getNome() + " não é o gerente deste time.");
        }
        if (productOwner != null) {
            throw new IllegalStateException("A empresa já possui Product Owner.");
        }
        time.removerGerente();
        gerente.substituirPapeis(new ProductOwner());
        this.productOwner = gerente;
    }

}