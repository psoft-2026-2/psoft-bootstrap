import java.util.LinkedHashSet;
import java.util.Set;

public class Funcionario {
    private final String nome;
    private final Set<TipoPapel> papeis = new LinkedHashSet<>();

    public Funcionario(String nome, TipoPapel papelInicial){
        this.nome = nome;
        this.papeis.add(papelInicial);
    }

    public void adicionarPapel(TipoPapel p) {papeis.add(p);}
    public void removerPapel(Papel t) {papeis.removeIf(p -> p.getTipo() == t);}
    public boolean temPapel(Papel t){
        return papeis.stream().anyMatch(p->p.getTipo() == t);
    }

}
