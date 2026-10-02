import java.util.ArrayList;
import java.util.List;

public class Colaborador {

    private String nome;
    private List<Papel> papeis = new ArrayList<>();

    public Colaborador(String nome) {
        this.nome = nome;
    }

    public void adicionaPapel(Papel papel) {
        if (!temPapel(papel.getClass())) {
            papeis.add(papel);
        }
    }

    public void removePapel(Class<? extends Papel> tipo) {
        papeis.removeIf(tipo::isInstance);
    }

    //agora é EXCLUSIVAMENTE o novo papel (dev -> gerente, gerente -> PO)
    public void promoveColab(Papel novoPapel) {
        papeis.clear();
        papeis.add(novoPapel);
    }

    //checa se o colaborador exerce um determinado papel
    public boolean temPapel(Class<? extends Papel> tipo) {
        return papeis.stream().anyMatch(tipo::isInstance);
    }

    public List<Papel> getPapeis() {
        return papeis;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        List<String> nomesDosPapeis = new ArrayList<>();
        for (Papel p : papeis) {
            nomesDosPapeis.add(p.getNome());
        }
        return nome + " -> papeis " + nomesDosPapeis;
    }
}
