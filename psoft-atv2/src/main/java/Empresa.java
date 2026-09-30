import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private Pessoa productOwner;
    private List<Time> times;

    public Empresa(String nome, Pessoa productOwner) {
        if (productOwner.getCargoAtual() != Cargo.PRODUCT_OWNER) {
            throw new IllegalArgumentException("O responsável por todos os produtos de software desenvolvidos deve possuir o cargo de Product Owner.");
        }
        this.nome = nome;
        this.productOwner = productOwner;
        this.times = new ArrayList<>();
    }

    public void adicionarTime(Time time) {
        this.times.add(time);
    }

    public String getNome() {
        return nome;
    }

    public Pessoa getProductOwner() {
        return productOwner;
    }

    public List<Time> getTimes() {
        return times;
    }
}
