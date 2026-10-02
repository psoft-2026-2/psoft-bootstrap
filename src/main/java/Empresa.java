
import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nome;
    private List<Time> times = new ArrayList<>();
    private Colaborador productOwner;

    public Empresa(String nome) {
        this.nome = nome;
    }

    public void adicionarTime(Time time) {
        times.add(time);
    }

    //só um colaborador com o papel de Product Owner pode ser o PO da empresa.
    public void definirProductOwner(Colaborador colaborador) {
        if (!colaborador.temPapel(ProductOwner.class)) {
            throw new IllegalArgumentException(
                "O colaborador '" + colaborador.getNome() + "' nao exerce o papel de Product Owner.");
        }
        this.productOwner = colaborador;
    }

    public String getNome() {
        return nome;
    }

    public List<Time> getTimes() {
        return times;
    }

    public Colaborador getProductOwner() {
        return productOwner;
    }
}
