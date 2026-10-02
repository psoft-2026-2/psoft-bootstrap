import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Time> times;
    private Pessoa productOwner;

    public Empresa() {
        this.times = new ArrayList<>();
    }

    public void adicionarTime(Time time) {
        times.add(time);
    }

    public void definirProductOwner(Pessoa productOwner) {
        this.productOwner = productOwner;
    }
}