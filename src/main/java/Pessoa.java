import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pessoa {
    private String id;
    private String nome;
    private String email;
    private List papeis;

    public Pessoa(String id, String nome, String email, Papel papelInicial) {
        if (papelInicial == null) {
            throw new IllegalArgumentException("Toda Pessoa precisa de pelo menos 1 papel inicial!");
        }
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.papeis = new ArrayList();
        this.papeis.add(papelInicial);
    }

    public void adicionarPapel(Papel novoPapel) {
        if (novoPapel != null) {
            if (!temPapel(novoPapel.getNome())) {
                this.papeis.add(novoPapel);
            }
        }
    }

    public boolean removerPapel(String nomePapel) {
        if (this.papeis.size() <= 1) {
            return false;
        }

        Iterator iterador = this.papeis.iterator();
        while (iterador.hasNext()) {
            Papel p = iterador.next();
            if (p.getNome().equalsIgnoreCase(nomePapel)) {
                iterador.remove();
                return true;
            }
        }
        return false;
    }

    public boolean temPapel(String nomePapel) {
        for (Papel p : this.papeis) {
            if (p.getNome().equalsIgnoreCase(nomePapel)) {
                return true;
            }
        }
        return false;
    }

    public void trabalhar() {
        for (Papel papel : this.papeis) {
            papel.executar();
        }
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public List getPapeis() { return papeis; }
}