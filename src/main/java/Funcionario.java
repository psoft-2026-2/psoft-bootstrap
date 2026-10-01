import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Funcionario {
    private String nome;
    private String cpf;
    private List<Papel> papeis; 

    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.papeis = new ArrayList<>();
    }

    public void adicionaPapel(Papel papel) {
        if (papel != null) {
            this.papeis.add(papel);
        }
    }

    public void removePapel(Class<? extends Papel> tipoPapel) {
        this.papeis.removeIf(p -> p.getClass().equals(tipoPapel));
    }

    public void realizarTrabalho() {
        System.out.println(nome + "iniciando o trabalho:");
        for (Papel papel : papeis) {
            papel.realizarTrabalho();
        }
    }

    public List<Papel> getPapeis() {
        return Collections.unmodifiableList(papeis);
    }
    
    public String getNome() { return nome; }
}