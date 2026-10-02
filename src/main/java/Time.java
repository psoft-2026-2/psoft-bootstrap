import java.util.HashMap;

public class Time {
    private int id;
    private Funcionario lider;
    private HashMap<Integer, Funcionario> devs;
    private Produto produto;

    public Time(int id, Funcionario lider, HashMap<Integer, Funcionario> devs, Produto produto) {
        this.id = id;
        this.lider = lider;
        this.devs = devs;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getLider() {
        return lider;
    }

    public void setLider(Funcionario lider) {
        this.lider = lider;
    }

    public HashMap<Integer, Funcionario> getDevs() {
        return devs;
    }

    public void setDevs(HashMap<Integer, Funcionario> devs) {
        this.devs = devs;
    }

    public void addMembro(Funcionario funcionario){
        devs.put(funcionario.getCodigo(), funcionario);
    }

    public String getProduto() {
        return produto.toString();
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
