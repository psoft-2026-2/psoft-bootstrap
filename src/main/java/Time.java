import java.util.ArrayList;
import java.util.List;

public class Time {
    private List<Desenvolvedor> desenvolvedores;
    private final String nome;

    public Time(String nome){
        this.desenvolvedores = new ArrayList<>();
        this.nome = nome;
    }

    public void addPessoas(Desenvolvedor desenvolvedor){
        this.desenvolvedores.add(desenvolvedor);
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }

    public String getNome() {
        return nome;
    }

    

}
