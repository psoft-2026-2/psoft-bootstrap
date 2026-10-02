import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private Funcionario productOwner;
    private List<Time> times;

    public Empresa(Funcionario productOwner) {
        this.productOwner = productOwner;
        this.times = new ArrayList<>();
    }

    public Funcionario getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(Funcionario productOwner) {
        this.productOwner = productOwner;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void addTime(Time time) {
        this.times.add(time);
    }

    public void removeTime(Time time) {
        this.times.remove(time);
    }
    
}
