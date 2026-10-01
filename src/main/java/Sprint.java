import java.util.ArrayList;
import java.util.List;

public class Sprint {
    private String nome;
    private Funcionario lider;
    private List<Requisito> requisitos;
    private List<Funcionario> desenvolvedores;

    public Sprint(String nome) {
        this.nome = nome;
        this.requisitos = new ArrayList<>();
        this.desenvolvedores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Funcionario getLider() {
        return lider;
    }

    public List<Requisito> getRequisitos() {
        return new ArrayList<>(requisitos);
    }

    public List<Funcionario> getDesenvolvedores() {
        return new ArrayList<>(desenvolvedores);
    }

    public void adicionarDesenvolvedor(Funcionario funcionario) {
        if (funcionario == null ||
            !funcionario.temFuncao(Desenvolvedor.class)) {
            throw new IllegalArgumentException(
                "É necessário ser desenvolvedor"
            );
        }

        if (!desenvolvedores.contains(funcionario)) {
            desenvolvedores.add(funcionario);
        }
    }

    public void adicionarRequisito(Requisito requisito) {
        requisitos.add(requisito);
    }

    public void definirLider(Funcionario funcionario) {
        if (!desenvolvedores.contains(funcionario)) {
            throw new IllegalArgumentException(
                "O líder deve fazer parte da Sprint"
            );
        }

        if (lider != null) {
            lider.removerFuncao(Lider.class);
        }

        funcionario.assumirLideranca();
        lider = funcionario;
    }

    public void encerrar() {
        if (lider != null) {
            lider.removerFuncao(Lider.class);
            lider = null;
        }
    }

}