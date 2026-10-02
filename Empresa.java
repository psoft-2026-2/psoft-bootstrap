import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private Funcionario productOwner;
    private List<Time> times = new ArrayList<>();

    public Time criarTime(Produto produto) {
        Time time = new Time(produto);
        times.add(time);
        return time;
    }

    public void promoverProductOwner(Funcionario gerente) {
        gerente.promover(new ProductOwner());
        productOwner = gerente;
    }

    public Funcionario getProductOwner() {
        return productOwner;
    }
}