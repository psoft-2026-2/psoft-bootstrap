import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private String id;
    private String nome;
    private List<Papel> papeis;

    public Funcionario(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.papeis = new ArrayList<>();
        this.papeis.add(new Desenvolvedor());
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean possuiPapel(String nome) {
        for (Papel p : papeis) {
            if (p.getPapel().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public boolean adicionarPapel(Papel p) {
        if (possuiPapel(p.getPapel())) {
            return false;
        }
        papeis.add(p);
        return true;
    }

    public boolean removerPapel(Papel p) {
        if (papeis.size() == 1) {
            return false;
        }
        for (Papel existente : papeis) {
            if (existente.getPapel().equals(p.getPapel())) {
                papeis.remove(existente);
                return true;
            }
        }
        return false;
    }

    public boolean promover(Papel novo) {
        String nome = novo.getPapel();
        if (nome.equals("Gerente") && possuiPapel("Desenvolvedor")) {
            papeis.clear();
            papeis.add(novo);
            return true;
        }
        if (nome.equals("ProductOwner") && possuiPapel("Gerente")) {
            papeis.clear();
            papeis.add(novo);
            return true;
        }
        return false;
    }
}
