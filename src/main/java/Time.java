import java.util.ArrayList;
import java.util.List;

public class Time {
    private String id;
    private Funcionario gerente;
    private List<Funcionario> funcionarios;
    private Produto produto;
    private Sprint sprint;

    public Time(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("id invalido");
        }
        this.id = id.trim();
        this.funcionarios = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Produto getProduto() {
        return produto;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void defineGerente(Funcionario gerente) {
        if (gerente == null) {
            throw new IllegalArgumentException("gerente invalido");
        }
        this.gerente = gerente;
    }

    public void addFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("funcionario invalido");
        }
        funcionarios.add(funcionario);
    }

    public void addProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("produto invalido");
        }
        this.produto = produto;
    }

    public void atualizaSprint() {
        if (sprint != null) {
            sprint.atualizaCiclo();
        }
    }

    public void defineSprint(Sprint sprint) {
        this.sprint = sprint;
    }
}
