import java.util.ArrayList;
import java.util.List;

public class Time {
    private Funcionario gerente;
    private List<Funcionario> equipe;
    private String nome;
    private Produto produto;
    private Sprint sprint;

    public Time(Funcionario gerente, String nome, Produto produto) {
        this.gerente = gerente;
        this.equipe = new ArrayList<>();
        this.nome = nome;
        this.produto = produto;
    }

	public Funcionario getGerente() {
		return gerente;
	}

	public void setGerente(Funcionario gerente) {
		this.gerente = gerente;
	}

	public List<Funcionario> getEquipe() {
		return equipe;
	}

	public void addFuncionario(Funcionario funcionario) {
        this.equipe.add(funcionario);
    }

    public void removeFuncionario(Funcionario funcionario) {
        this.equipe.remove(funcionario);
    }

	public String getNome() {
		return nome;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}
    
}
