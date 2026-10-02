import java.util.LinkedHashMap;
import java.util.Map;

public class Empresa {
    private String nome;
    private Funcionario productOwner;
    private Map<Integer, Time> times;

    public Empresa(String nome, Funcionario po) {
        this.nome = nome;
        this.productOwner = po;
        this.times = new LinkedHashMap<>();

        if (po.possuiFuncao(Gerente.class)) {
            po.promove();
        }
    }

    public void addTime(String nome, Funcionario ger, Produto produto) {
        Time time = new Time(nome, ger, produto);
        times.put(time.getId(), time);
    }

    public Time getTime(int id) {
        return times.get(id);
    }

    public Time removeTime(int id) {
        return times.remove(id);
    }

    public String getNome() {
        return nome;
    }

    public Funcionario getProductOwner() {
        return productOwner;
    }

    public Map<Integer, Time> getTimes() {
        return times;
    }
}
