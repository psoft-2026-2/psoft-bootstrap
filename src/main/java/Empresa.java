import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private List<Time> times;
    private Funcionario productOwner;

    public Empresa(String nome) {
        this.nome = nome;
        this.times = new ArrayList<>();
    }

    public void setProductOwner(Funcionario po) {
        this.productOwner = po;
    }

    public void adicionaTime(Time time) {
        this.times.add(time);
    }
}