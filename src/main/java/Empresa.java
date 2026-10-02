import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private List<Time> times;
    private Funcionario po;

    public Empresa(String nome) {
        this.nome = nome;
        this.times = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String newNome) {
        this.nome = newNome;
    }

    public void addTime(Time time) {
        this.times.add(time);
    }

    public Time getTime(String nome) {
        for (Time time : times) {
            if (time.getNome().equals(nome)) {
                return time;
            }
        }
        return null;
    }

    public Funcionario getPo() {
        return po;
    }

    public void promoverAPo(Funcionario func) {
        this.po = func;
        if (func != null) {
            func.addPapel(new ProductOwner());
        }
    }

    public void removeTime(String nome) {
        this.times.removeIf(time -> time.getNome().equals(nome));
    }
}
