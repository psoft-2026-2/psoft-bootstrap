import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private Funcionario productOwner;
    private List<Time> times;

    public Empresa(String nome, Funcionario productOwner) {
        if (productOwner.getPapel() != Papel.PRODUCT_OWNER) {
            throw new IllegalArgumentException("A empresa precisa de um Product Owner.");
        }
        this.nome = nome;
        this.productOwner = productOwner;
        this.times = new ArrayList<>();
    }

    public void adicionarTime(Time time) {
        this.times.add(time);
    }

    public String getNome() {
        return this.nome;
    }

    public Funcionario getProductOwner() {
        return this.productOwner;
    }

    public void setProductOwner(Funcionario productOwner) {
        if (productOwner.getPapel() != Papel.PRODUCT_OWNER) {
            throw new IllegalArgumentException("O funcionario precisa ser Product Owner.");
        }
        this.productOwner = productOwner;
    }

    public List<Time> getTimes() {
        return this.times;
    }
}
