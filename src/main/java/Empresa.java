import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private List<Funcionario> funcionarios;
    private List<Time> times;

    public Empresa(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("nome invalido");
        }
        this.nome = nome.trim();
        this.funcionarios = new ArrayList<>();
        this.times = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void adicionaFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("funcionario invalido");
        }
        funcionarios.add(funcionario);
    }

    public void adicionaTime(Time time) {
        if (time == null) {
            throw new IllegalArgumentException("time invalido");
        }
        times.add(time);
    }

    public void promove(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("funcionario invalido");
        }
        if (funcionario.getFuncao() instanceof Desenvolvedor) {
            funcionario.defineFuncao(new Gerente());
        } else if (funcionario.getFuncao() instanceof Gerente) {
            funcionario.defineFuncao(new ProductOwner());
        }
    }
}
