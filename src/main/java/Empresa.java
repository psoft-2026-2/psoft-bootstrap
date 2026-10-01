import java.util.HashMap;
import java.util.Map;

public class Empresa {

    private String nome;
    private Funcionario productOwner;
    private Map<String, Time> times = new HashMap<>();

    public Empresa(String nome, Funcionario PO) {
        this.nome = nome;
        this.productOwner = PO;
        PO.adicionarPapel(new ProductOwner(this));
    }

    public void adicionarTime(String id, String nome, Funcionario g) {
        times.put(id, new Time(id, nome, g));
    }

    public void removerTime(Time t) {
        times.remove(t.getId());
    }

    public String getNome() {
        return nome;
    }

    public Funcionario getPO() {
        return productOwner;
    }

    public Map<String, Time> getTimes() {
        return new HashMap<>(times);
    }
}
