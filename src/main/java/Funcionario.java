import java.util.ArrayList;
import java.util.List;

public class Funcionario {

    private String nome, matricula;
    private List<Papel> papeis;

    public Funcionario(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        papeis = new ArrayList<>();
    }

    public void addPapel(Papel papel) {
        if (temPapel(papel.getClass()))
            throw new IllegalArgumentException(nome + " já possui o papel " + papel.getNome());
        papeis.add(papel);
    }

    public void removePapel(Papel papel) {
        if (!papeis.removeIf(p -> p.getClass() == papel.getClass()))
            throw new IllegalArgumentException(nome + " não possui o papel " + papel.getNome());
    }

    public boolean temPapel(Class<? extends Papel> tipo) {
        return papeis.stream().anyMatch(p -> p.getClass() == tipo);
    }

    public String getNome() {return nome;}

    public String getMatricula() {return matricula;}

    public List<Papel> getPapeis() {return papeis;}

    @Override
    public String toString() {
        return "Funcionario [nome=" + nome + ", matricula=" + matricula + ", papeis=" + papeis + "]";
    }

    @Override
    public int hashCode() {
        return matricula == null ? 0 : matricula.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Funcionario other = (Funcionario) obj;
        return matricula == null ? other.matricula == null : matricula.equals(other.matricula);
    }
}
