import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private Pessoa productOwner;
    private List<Time> times;

    public Empresa(String nome, Pessoa po) {
        if (!po.possuiPapel("ProductOwner")) {
            throw new IllegalArgumentException("O Product Owner deve ter o papel ProductOwner.");
        }
        this.nome = nome;
        this.productOwner = po;
        this.times = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Pessoa getProductOwner() {
        return productOwner;
    }

    public boolean adicionarTime(String id, String nome, Produto prod, Pessoa gerente) {
        if (contemTime(id) || !gerente.possuiPapel("Gerente")) {
            return false;
        }
        times.add(new Time(id, nome, prod, gerente));
        return true;
    }

    public Time getTime(String id) {
        for (Time t : times) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public List<Time> getTimes() {
        return new ArrayList<>(times);
    }

    // Método auxiliar privado para substituir a verificação de chave do Map
    private boolean contemTime(String id) {
        return getTime(id) != null;
    }
}