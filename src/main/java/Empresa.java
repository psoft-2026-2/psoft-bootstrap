import java.util.LinkedHashMap;
import java.util.Map;

public class Empresa {
    private String nome;
    private Funcionario productOwner;
    private Map<String, Time> times;

    public Empresa(String nome, Funcionario po) {
        if (!po.possuiPapel("ProductOwner")) {
            throw new IllegalArgumentException("O Product Owner deve ter o papel ProductOwner.");
        }
        this.nome = nome;
        this.productOwner = po;
        this.times = new LinkedHashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public Funcionario getProductOwner() {
        return productOwner;
    }

    public boolean adicionarTime(String id, String nome, Produto prod, Funcionario gerente) {
        if (times.containsKey(id) || !gerente.possuiPapel("Gerente")) {
            return false;
        }
        times.put(id, new Time(id, nome, prod, gerente));
        return true;
    }

    public Time getTime(String id) {
        return times.get(id);
    }

    public Map<String, Time> getTimes() {
        return new LinkedHashMap<>(times);
    }
}
