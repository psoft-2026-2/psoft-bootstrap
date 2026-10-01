import java.util.List;

public class Time {

    private String nome;
    private List<Funcionario> equipe;
    private Funcionario gerente;

    public Time(String nome, List<Funcionario> equipe, Funcionario gerente) {
        this.nome = nome;
        this.equipe = equipe;
        this.gerente = gerente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novo) {
        this.nome = novo;
    }

    public List<Funcionario> getEquipe() {
        return equipe;
    }

    public void setEquipe(List<Funcionario> nova) {
        this.equipe = nova;
    }

    public void addEquipe(Funcionario novo) {
        equipe.add(novo);
    }

    public void removeEquipe(Funcionario funcionario) {
        equipe.remove(funcionario);
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public void setGerente(Funcionario novo) {
        this.gerente = novo;
    }
}
