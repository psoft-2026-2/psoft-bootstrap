import java.util.ArrayList;
import java.util.List;

public class Time {
    private String nome;
    private List<Funcionario> desenvolvedores;
    private Funcionario gerente;
    private Software software;

    public Time(String nome, Funcionario gerente,
                Software software) {
        this.nome = nome;
        this.gerente = gerente;
        this.software = software;
        this.desenvolvedores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Funcionario> getDesenvolvedores() {
        return new ArrayList<>(desenvolvedores);
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public Software getSoftware() {
        return software;
    }

    public void setGerente(Funcionario gerente) {
        if (gerente == null ||
            !gerente.temFuncao(Gerente.class)) {
            throw new IllegalArgumentException(
                "O funcionário precisa ser gerente"
            );
        }

        this.gerente = gerente;
    }

    public void adicionarDesenvolvedor(Funcionario funcionario) {
        if (funcionario == null ||
            !funcionario.temFuncao(Desenvolvedor.class)) {
            throw new IllegalArgumentException(
                "O funcionário precisa ser desenvolvedor"
            );
        }

        if (!desenvolvedores.contains(funcionario)) {
            desenvolvedores.add(funcionario);
        }
    }

    public void removerDesenvolvedor(Funcionario funcionario) {
        desenvolvedores.remove(funcionario);
    }

    public void promoverDesenvolvedorParaGerente(
        Funcionario funcionario) {

        if (!desenvolvedores.contains(funcionario)) {
            throw new IllegalArgumentException(
                "O funcionário não é desenvolvedor deste time"
            );
        }

        funcionario.promoverParaGerente();

        desenvolvedores.remove(funcionario);
        gerente = funcionario;
    }

}