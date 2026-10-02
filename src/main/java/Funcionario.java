import java.util.ArrayList;
import java.util.List;
//Classe Desenvolvedor do diagrama, mudei o nome pra não repetir na classe que implementa a interface de papel
public class Funcionario {
    private String nome;
    private Integer id;
    private List<Papel> papeis;

    public Funcionario(String nome) {
        this.nome = nome;
        this.papeis = new ArrayList<>();
    }

    public void addPapel(Papel papel) {
        this.papeis.add(papel);
    }

    public void removePapel(Papel papel) {
        this.papeis.remove(papel);
    }

    public void Trabalhar() {
        for (Papel papel : papeis) {
            papel.Trabalhar();
        }
    }
}
