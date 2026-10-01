import java.util.ArrayList;
import java.util.List;

public class Funcionario {

    private String id;
    private String nome;
    private List<Papel> papeis = new ArrayList<>();

    /** Todo funcionário começa como desenvolvedor. */
    public Funcionario(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.papeis.add(new Dev());
    }

    public void adicionarPapel(Papel p) {
        papeis.add(p);
    }

    public void removerPapel(Papel p) {
        papeis.remove(p);
    }

    /**
     * Promove o funcionário: Dev -> Gerente (função exclusiva) ou
     * Gerente -> ProductOwner (função exclusiva).
     */
    public void promover(Papel p) {
        if (p instanceof Gerente) {
            if (!possuiPapel(Dev.class)) {
                throw new IllegalStateException("Apenas desenvolvedores podem ser promovidos a gerente");
            }
        } else if (p instanceof ProductOwner) {
            if (!possuiPapel(Gerente.class)) {
                throw new IllegalStateException("Apenas gerentes podem ser promovidos a Product Owner");
            }
        } else {
            throw new IllegalArgumentException("Promoção inválida: " + p.getClass().getSimpleName());
        }
        papeis.clear();
        papeis.add(p);
    }

    public boolean possuiPapel(Class<? extends Papel> tipo) {
        return papeis.stream().anyMatch(tipo::isInstance);
    }

    /** Retorna o papel do tipo dado, ou null se não houver. */
    public <T extends Papel> T getPapel(Class<T> tipo) {
        return papeis.stream().filter(tipo::isInstance).map(tipo::cast).findFirst().orElse(null);
    }

    /** Retorna o papel de líder associado à sprint dada, ou null. */
    Lider getPapel(Class<Lider> tipo, Sprint s) {
        return papeis.stream().filter(tipo::isInstance).map(tipo::cast)
                .filter(l -> l.getSprint() == s).findFirst().orElse(null);
    }

    public List<Papel> getPapeis() {
        return new ArrayList<>(papeis);
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }
}
