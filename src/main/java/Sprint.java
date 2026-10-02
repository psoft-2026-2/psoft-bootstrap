import java.util.HashMap;

public class Sprint {
    private int id;
    private Funcionario productowner;
    private HashMap<Integer, Time> times;

    public Sprint(int id, Funcionario productowner, HashMap<Integer, Time> times) {
        this.id = id;
        this.productowner = productowner;
        this.times = times;
    }

    public void addMembro(Integer idTime,Funcionario funcionario){
        times.get(idTime).addMembro(funcionario);
    }

    public Funcionario getProductowner() {
        return productowner;
    }

    public void setProductowner(Funcionario productowner) {
        this.productowner = productowner;
    }

    public String getStatus(Integer id){
        return times.get(id).getProduto();
    }
}
