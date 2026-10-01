import java.util.*;

public class Produto {
    private int id;
    private String nome;
    private ArrayList<Pessoa> time;
    private ArrayList<Sprint> sprints;

    public Produto(int id, String nome, ArrayList<Pessoa> time) {
        this.id = id;
        this.nome = nome;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Pessoa> getTime() {
        return time;
    }

    public ArrayList<Sprint> getSprints() {
        return sprints;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addPessoaNoTime(Pessoa pessoa) {
        this.time.add(pessoa);
    }

    public void removePessoaDoTime(Pessoa pessoa) {
        this.time.remove(pessoa);
    }

    public void addSprint(String descricao, Pessoa lider) {
        Lider novoLider = new Lider(lider);
        Sprint novoSprint = new Sprint(descricao, novoLider);
        this.sprints.add(novoSprint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
        Produto other = (Produto) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Nome: " + nome;
    }
}